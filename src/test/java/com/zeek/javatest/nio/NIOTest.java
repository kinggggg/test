package com.zeek.javatest.nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;

/**
 * Created by weibo_li on 2017/3/1.
 */
public class NIOTest {

    /**
     * @Description: 对映射内存缓冲区进行修改，同步到文件中
     * @Author: liweibo
     * @Date: 2018/12/20 下午10:58
     * @Version: v1.0
     *
     * @Param
     *
     * @Return: void
     **/
    @Test
    public void writeMemoryMapperTest() throws Exception {

        // 随机访问文件
        RandomAccessFile raf = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/com/zeek/javatest/nio/des/tcp-ip.png", "rw");
        // 得到文件通道
        FileChannel fc = raf.getChannel();

        // 创建与file相对应的内存字节缓冲区
        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());

        for (int i = 500; i < 350000; i++) {
            buffer.put(i, (byte)0);
        }

        fc.close();
        raf.close();
    }

    /**
     * @Description: 读取映射的字节缓冲区
     * @Author: liweibo
     * @Date: 2018/12/20 下午10:58
     * @Version: v1.0
     *
     * @Param
     *
     * @Return: void
     **/
    @Test
    public void readMemoryMapperTest() throws Exception {

        // 随机访问文件
        RandomAccessFile raf = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/com/zeek/javatest/nio/src/tcp-ip.png", "rw");
        // 得到文件通道
        FileChannel fc = raf.getChannel();

        System.out.println("fileLength : " + raf.length());

        // 创建与file相对应的内存字节缓冲区
        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
        int cap = buffer.capacity();
        System.out.println("buffer cap : " + cap);

        FileChannel fcout = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/com/zeek/javatest/nio/des/tcp-ip.png", "rw").getChannel();
        fcout.write(buffer);
        fcout.close();

        fc.close();
        raf.close();
    }

    @Test
    public void directBufferTest2() throws Exception {

        //分配100MB的直接字节缓冲区（或者称之为离堆，或者称之为非堆）
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024); //虽然分配了100MB，但是此空间不是占用的JVM的堆空间，而是直接从机器的内存中分配的

        Class clazz = Class.forName("java.nio.DirectByteBuffer");
        Method m = clazz.getDeclaredMethod("cleaner");
        m.setAccessible(true);
        Object cleaner = m.invoke(byteBuffer);

        clazz = Class.forName("sun.misc.Cleaner");
        m = clazz.getDeclaredMethod("clean");
        m.setAccessible(true);
        m.invoke(cleaner);

    }


    @Test
    public void directBufferTest() {

        //分配100MB的直接字节缓冲区（或者称之为离堆，或者称之为非堆）
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 100); //虽然分配了100MB，但是此空间不是占用的JVM的堆空间，而是直接从机器的内存中分配的

        System.gc();// 由于离堆占用的内存是机器的内存，而不是JVM的堆空间，因此JVM的垃圾回收线程无法回收这块空间

        byteBuffer = null;
        System.gc();// 即使将其置为null，JVM的垃圾回收线程也无法对此区域的内存进行回收，因为这块内存空间根本不受JVM管理



    }

    @Test
    public void nioCopy() throws Exception {

        long start = System.currentTimeMillis();

        //源文件
        RandomAccessFile srcRaf = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/com/zeek/javatest/nio/src/tcp-ip.png", "r");
        FileChannel srcRafChannel = srcRaf.getChannel();

        //缓冲区 1M
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //目标文件
        RandomAccessFile descRaf = new RandomAccessFile("/Users/weibo_li/Documents/code/Test/src/test/java/com/zeek/javatest/nio/des/tcp-ip.png", "rw");
        //目标文件通道
        FileChannel descRafChannel = descRaf.getChannel();

        while(srcRafChannel.read(buffer) != -1) {
            //拍板
            buffer.flip();
            //将缓冲区数据写入到channel中
            descRafChannel.write(buffer);
            //清除缓冲区
            buffer.clear();
        }

        System.out.println("总共耗时 ：" + (System.currentTimeMillis() -  start) / 1000 + "秒");

        //释放资源
        srcRafChannel.close();
        srcRaf.close();
        descRafChannel.close();
        descRaf.close();


    }

    @Test
    public void test3() {


        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("mark: " + byteBuffer.mark());
        System.out.println("position: " + byteBuffer.position());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("capatity" + byteBuffer.capacity());

        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        byteBuffer.put((byte) 4);

        byteBuffer.flip();
        System.out.println(byteBuffer.get(0));
        System.out.println(byteBuffer.get(1));
        System.out.println(byteBuffer.get(2));
        System.out.println(byteBuffer.get(3));

        //当调用clear方法后，position为0，limit=capacity=10
        byteBuffer.clear();


    }

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
