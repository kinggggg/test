package com.zeek.test.ByteBuffer;

import java.nio.CharBuffer;

/**
 * Description:
 * Created by weibo_li
 * Date: 2017-12-13 下午3:07
 */
public class BufferFillDrain {

    public static void main(String[] args) {

        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }


    }

    private static void drainBuffer(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            System.out.println(charBuffer.get());
        }
    }

    private static boolean fillBuffer(CharBuffer charBuffer) {
        if(index >= strings.length) {
            return false;
        }

        String string = strings[index++];

        for(int i = 0; i < string.length(); i++){
            charBuffer.put(string.charAt(i));
        }

        return true;
    }

    public static int index = 0 ;

    /*private static String [] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly", // Sorry Jimi ;-)
            "Help Me! Help Me!",
    };*/

    private static String [] strings = {
            "hello",
            "world",
    };
}
