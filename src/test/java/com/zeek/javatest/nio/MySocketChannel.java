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

        // 打开一个挑选器
        Selector selector = Selector.open();

        //开启SocketChannel
        SocketChannel sc = SocketChannel.open();
        //创建连接地址
        SocketAddress addr = new InetSocketAddress("localhost", 8888);

        sc.configureBlocking(false);

        //进行连接
        boolean b = sc.connect(addr);
        System.out.println("connect() : " + b); //判断连接是否完成

//        while(sc.finishConnect() == false) {
//            System.out.println("继续等待连接完成");
//        }

        sc.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);


        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {
            // 让挑选器进行挑选，该方法是阻塞的，起码至少有一个被挑选出来
            selector.select();
            // 获得挑选的key集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> it = selectionKeys.iterator();
            while(it.hasNext()) {
                SelectionKey key = it.next();
                // 判断可连接
                if(key.isConnectable()) {
                    System.out.println("client : connectable");
                }
                // 可读
                if(key.isReadable()) {
                    System.out.println("receive server info : " + readStringFromChannel(sc));

                }
                // 可写
                if(key.isWritable()) {
                    writeMessageToServer(sc, "hi, i am client");
                }
            }

        }

        //System.out.println("连接完成");

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
