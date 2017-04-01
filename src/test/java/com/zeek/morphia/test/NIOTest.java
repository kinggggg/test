package com.zeek.morphia.test;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;

/**
 * Created by weibo_li on 2017/3/1.
 */
public class NIOTest {

    @Test
    public void test2() throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/1.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(2);

        int bytesRead = inChannel.read(buf); //read into buffer.
        while (bytesRead != -1) {

            buf.flip();  //make buffer ready for read

            System.out.println("------------------");
            System.out.println("position: " + buf.position());
            System.out.println("limit: " + buf.limit());

            while(buf.hasRemaining()){
                System.out.println((char) buf.get()); // read 1 byte at a time
                System.out.println("================");
                System.out.println("position: " + buf.position());
                System.out.println("limit: " + buf.limit());
            }

            buf.compact(); //make buffer ready for writing
            System.out.println("------------------");
            System.out.println("position: " + buf.position());
            System.out.println("limit: " + buf.limit());

            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    @Test
    public void test1() throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/1.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }

        aFile.close();
    }

    @Test
    public void test() throws IOException {
        Pipe pipe = Pipe.open();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("test".getBytes());
        buf.flip();
        sinkChannel.write(buf);
        System.out.println(buf.position());

        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        System.out.println(buf.position());
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();
    }
}
