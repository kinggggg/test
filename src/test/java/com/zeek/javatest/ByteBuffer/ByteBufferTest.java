package com.zeek.javatest.ByteBuffer;

import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    @Test
    public void test0() {

        String str = "helloWorld";
        ByteBuffer buff  = ByteBuffer.wrap(str.getBytes());
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());
        //读取两个字节
        byte b = buff.get();
        System.out.println(new String(new byte[]{b}));
        byte bb = buff.get();
        System.out.println(new String(new byte[]{bb}));
        System.out.println("position:"+ buff.position()+"\t limit:"+buff.limit());
        buff.mark();
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());
        buff.flip();
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());

    }
}
