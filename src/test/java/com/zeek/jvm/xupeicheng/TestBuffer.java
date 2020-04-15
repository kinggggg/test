package com.zeek.jvm.xupeicheng;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @ClassName TestBuffer
 * @Description
 * @Author liweibo
 * @Date 2018/12/18 下午10:35
 * @Version v1.0
 **/
public class TestBuffer {

    //分配缓冲区
    @Test
    public void allocateBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        //-1
        System.out.println("mark : " + buffer.mark());
        //0
        System.out.println("posi : " + buffer.position());
        //10
        System.out.println("limi : " + buffer.limit());
        //10
        System.out.println("capa : " + buffer.capacity());
        //10
        System.out.println("rema : " + buffer.remaining());

        System.out.println("---------------------------");
        //写入数据
        buffer.put((byte)1);
        buffer.put((byte)2);
        buffer.put((byte)3);
        buffer.put((byte)4);

        System.out.println("---------------------------");
        buffer.flip();

        //
        System.out.println("mark : " + buffer.mark());
        //
        System.out.println("posi : " + buffer.position());
        //
        System.out.println("limi : " + buffer.limit());
        //
        System.out.println("capa : " + buffer.capacity());
        //
        System.out.println("rema : " + buffer.remaining());

        System.out.println("---------------------------");

        System.out.println("get : " + buffer.get());
        System.out.println("get : " + buffer.get());
        System.out.println("get : " + buffer.get());
        System.out.println("get : " + buffer.get());

    }
}
