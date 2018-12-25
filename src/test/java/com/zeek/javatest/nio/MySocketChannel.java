package com.zeek.javatest.nio;

import org.apache.ibatis.annotations.SelectKey;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName MyServerSocketChannel
 * @Description 客户端SocketChannel
 * @Author liweibo
 * @Date 2018/12/20 下午11:29
 * @Version v1.0
 **/
public class MySocketChannel {

    @Test
    public void client() throws Exception {

        //开启SocketChannel
        SocketChannel sc = SocketChannel.open();
        //创建连接地址
        SocketAddress addr = new InetSocketAddress("localhost", 8888);

        sc.configureBlocking(false);

        //进行连接
        boolean b = sc.connect(addr);
        System.out.println("connect() : " + b); //判断连接是否完成

        while(sc.finishConnect() == false) {
            // continue
        }

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int i = 1;
        while(true) {
            String str = i + "" ;
            System.out.println("client : " + str);
            buffer.clear();
            buffer.put(str.getBytes());
            buffer.flip();
            sc.write(buffer);
            buffer.clear();
            i++;

            Thread.sleep(500);
        }

    }

    private void writeMessageToServer(SocketChannel sc, String msg) {

        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            buffer.put(msg.getBytes());
            buffer.flip();
            sc.write(buffer);
            buffer.clear();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    //从通道中读取字符串
    private String readStringFromChannel(SocketChannel sc) {

        StringBuilder builder = new StringBuilder();

        try {
            ByteBuffer buffer = ByteBuffer.allocate(2014);
            while (sc.read(buffer) != -1) {
                buffer.flip();

                builder.append(new String(buffer.array(), 0, buffer.limit()));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();

    }
}
