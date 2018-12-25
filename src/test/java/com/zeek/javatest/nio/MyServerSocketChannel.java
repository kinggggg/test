package com.zeek.javatest.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName MyServerSocketChannel
 * @Description 服务器端ServerSocketChannel
 * @Author liweibo
 * @Date 2018/12/20 下午11:29
 * @Version v1.0
 **/
public class MyServerSocketChannel {

    @Test
    public void server() throws Exception {

        // 打开一个挑选器
        Selector selector = Selector.open();

        //开启服务器Socket通道，但是未绑定
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //创建绑定地址
        SocketAddress addr = new InetSocketAddress("localhost", 8888);
        //进行绑定
        ssc.bind(addr);
        //配置非阻塞（也可以配置阻塞模式）
        ssc.configureBlocking(false);

        // 在挑选器中注册ssc，指定SelectionKey.OP_CONNECT
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        SocketChannel schTmp = null;

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {
            // 让挑选器进行挑选，该方法是阻塞的，起码至少有一个被挑选出来
            selector.select();
            // 获得挑选的key集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while(it.hasNext()) {
                SelectionKey key = it.next();

                // 1.判断ssc是否发生了accept事件
                if(key.isAcceptable()) {
                    // 其实ch与ssc是同一个对象
                    ServerSocketChannel ch = (ServerSocketChannel)key.channel();
                    // 接受连接
                    schTmp = ch.accept();
                    schTmp.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                }

                // 2.判断可连接
                if(key.isConnectable()) {
                    schTmp = (SocketChannel)key.channel();
                    System.out.println(schTmp + " : Connectable!!!");
                }
                // 3.可读
                if(key.isReadable()) {
                    schTmp = (SocketChannel)key.channel();
                    while (schTmp.read(buffer) != -1) {
                        buffer.flip();
                        byte[] array = buffer.array();
                        String str = new String(array, 0, buffer.limit());
                        System.out.println("from Client : " + schTmp + " : " + str);

                        buffer.clear();

                    }
                }
                // 3.可写
                if(key.isWritable()) {
                    schTmp = (SocketChannel)key.channel();
                    buffer.clear();
                    buffer.put("hi, i am server!!".getBytes());
                    buffer.flip();
                    schTmp.write(buffer);
                    System.out.println(schTmp + " : ");
                }
            }
        }

        /*while (true) {
            //接受连接请求
            SocketChannel sc = ssc.accept();
            System.out.println("over ：" + sc);

            Thread.sleep(1000);
        }*/


    }
}
