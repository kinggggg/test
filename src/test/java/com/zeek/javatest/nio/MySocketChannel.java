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

        Selector selector = Selector.open();

        //开启SocketChannel
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", 8888));

        sc.configureBlocking(false);

        sc.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> it = selectionKeys.iterator();
            while(it.hasNext()) {
                SelectionKey key = it.next();

                // 1.判断可连接
                if(key.isConnectable()) {
                    System.out.println("client is connectable");
                }
                // 2.可读
                if(key.isReadable()) {
                    buffer.clear();
                    sc.read(buffer);
                    buffer.flip();
                    System.out.println("client is isReadable receive : " + new String(buffer.array(), 0, buffer.limit()));
                }
                // 3.可写
                if(key.isWritable()) {
                    buffer.clear();
                    buffer.put("hi, i am client".getBytes());
                    buffer.flip();
                    sc.write(buffer);
                    System.out.println("client is isWritable send : hi, i am client" );
                }
            }
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
