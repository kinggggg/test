package com.zeek.test.ByteBuffer;

import org.junit.Test;
import scala.Char;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class CharBufferTest {

    @Test
    public void test2() throws Exception {

        char c = 'a';
        char b = 'a';
    }

    @Test
    public void test1() throws Exception {
        CharBuffer src = null;
        CharBuffer des = null;
        try {
            src = CharBuffer.allocate(3);
            src.put("a");
            src.put("b");
            src.put('c');//字符串和字符的效果一样
            src.flip();

            des = CharBuffer.allocate(2);
            while (src.hasRemaining()) {
                des.put(src.get());
            }
            System.out.println(new String(des.array()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test0() {

        CharBuffer charBuffer = CharBuffer.allocate(2);
        charBuffer.put('a');
        charBuffer.put('b');

        charBuffer.flip();

        char[] bigArray = new char[100];
        int length = charBuffer.remaining();

        charBuffer.get(bigArray, 0, length);

        System.out.println(new String(bigArray));


    }
}
