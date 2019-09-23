package com.zeek.javatest.stm.firstexample;

/**
 * @ClassName Account
 * @Description
 * @Author liweibo
 * @Date 2019/9/23 3:13 PM
 * @Version v1.0
 **/
class Account {
    // 余额
    private TxnRef<Integer> balance;
    // 构造方法
    public Account(int balance) {
        this.balance = new TxnRef<Integer>(balance);
    }
    // 转账操作
    public void transfer(Account target, int amt){
        STM.atomic((txn)->{
            Integer from = balance.getValue(txn);
            balance.setValue(from-amt, txn);
            Integer to = target.balance.getValue(txn);
            target.balance.setValue(to+amt, txn);
        });
    }

    public static void main(String[] args) {
        Account from = new Account(10);

        Account target = new Account(20);

        from.transfer(target, 10);

        from.transfer(target, 10);
    }
}

