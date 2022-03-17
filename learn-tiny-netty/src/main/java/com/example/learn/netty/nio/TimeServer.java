package com.example.learn.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class TimeServer {
    private void bind(int port){
        // 1.打开ServerSocketChannel管道
        try(ServerSocketChannel acceptChannel = ServerSocketChannel.open()) {
            // 2.设置管道为非阻塞状态
            acceptChannel.configureBlocking(false);
            //3.绑定管道端口
            acceptChannel.bind(new InetSocketAddress(port));
            //4.创建多路复用器selector
            Selector selector = Selector.open();
            //5.将管道注册到多路复用器上
            acceptChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 6.使用，轮询多路复用器selector 看是否有准备就绪的io事件
            while (selector.select()>0){
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()){
                    // 取出key后充selector中移除掉
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()){
                        // 通知accept就绪
                        System.out.println("客户端连接成功");
                        ServerSocketChannel tempServerChannel = (ServerSocketChannel) key.channel();
                        //  取出客户端的channel管道
                        SocketChannel socketChannel = tempServerChannel.accept();
                        // 将客户端管道设置为非阻塞的
                        socketChannel.configureBlocking(false);
                        // 将客户端注册read事件到selector多路复用器上
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if (key.isReadable()){
                        // 通知read事件就绪
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        // 新建一个 ByteBuffer用于读取
                        ByteBuffer buffer = ByteBuffer.allocate(8192);
                        int size = socketChannel.read(buffer);
                        if (size == -1){
                            socketChannel.close();
                            return;
                        }
                        //调用flip()之后，读/写指针position指到缓冲区头部，并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
                        buffer.flip();
                        byte[] bts = new byte[buffer.remaining()];
                        buffer.get(bts);
                        String str = new String(bts);
                        System.out.println("接收到客户端数据："+str);
                        buffer.clear();
                        // 判断客户端输入的字符串是否为Get Date
                        if (str.equalsIgnoreCase("Get Date")){
                            // 输出服务器时间字符串
                            buffer.put(new Date().toString().getBytes());
                        }else {
                            // 提示客户端请求有误
                            buffer.put("Bad Request".getBytes());
                        }
                        buffer.flip();
                        socketChannel.write(buffer);

                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TimeServer().bind(8989);
    }
}
