package com.zeek.javatest.stm.firstexample;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName STMTest
 * @Description
 * @Author liweibo
 * @Date 2019/9/23 2:48 PM
 * @Version v1.0
 **/
public class STMTest {
}

// 带版本号的对象引用
final class VersionedRef<T> {
    final T value;
    final long version;
    // 构造方法
    public VersionedRef(T value, long version) {
        this.value = value;
        this.version = version;
    }
}

// 支持事务的引用
class TxnRef<T> {
    // 当前数据，带版本号
    volatile VersionedRef curRef;
    // 构造方法
    public TxnRef(T value) {
        this.curRef = new VersionedRef(value, 0L);
    }
    // 获取当前事务中的数据
    public T getValue(Txn txn) {
        return txn.get(this);
    }
    // 在当前事务中设置数据
    public void setValue(T value, Txn txn) {
        txn.set(this, value);
    }
}


//STM 事务实现类
final class STMTxn implements Txn {
    // 事务 ID 生成器
    private static AtomicLong txnSeq = new AtomicLong(0);

    // 当前事务所有的相关数据
    private Map<TxnRef, VersionedRef> inTxnMap = new HashMap<>();
    // 当前事务所有需要修改的数据
    private Map<TxnRef, Object> writeMap = new HashMap<>();
    // 当前事务 ID
    private long txnId;
    // 构造函数，自动生成当前事务 ID
    STMTxn() {
        txnId = txnSeq.incrementAndGet();
    }

    // 获取当前事务中的数据
    @Override
    public <T> T get(TxnRef<T> ref) {
        // 将需要读取的数据，加入 inTxnMap
        if (!inTxnMap.containsKey(ref)) {
            inTxnMap.put(ref, ref.curRef);
        }
        return (T) inTxnMap.get(ref).value;
    }
    // 在当前事务中修改数据
    @Override
    public <T> void set(TxnRef<T> ref, T value) {
        // 将需要修改的数据，加入 inTxnMap
        if (!inTxnMap.containsKey(ref)) {
            inTxnMap.put(ref, ref.curRef);
        }
        writeMap.put(ref, value);
    }
    // 提交事务
    boolean commit() {
        synchronized (STM.commitLock) {
            // 是否校验通过
            boolean isValid = true;
            // 校验所有读过的数据是否发生过变化
            for(Map.Entry<TxnRef, VersionedRef> entry : inTxnMap.entrySet()){
                VersionedRef curRef = entry.getKey().curRef;
                VersionedRef readRef = entry.getValue();
                // 通过版本号来验证数据是否发生过变化
                if (curRef.version != readRef.version) {
                    isValid = false;
                    break;
                }
            }
            // 如果校验通过，则所有更改生效
            if (isValid) {
                writeMap.forEach((k, v) -> {
                    k.curRef = new VersionedRef(v, txnId);
                });
            }
            return isValid;
        }
    }
}


