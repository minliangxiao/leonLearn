package com.example.learn.mq.mqbynetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty实现mq服务
 */
public class NettyMQServer {

    public void bind(int port){
        /**
         * Netty 抽象出两组线程池BossGroup和WorkerGroup
         * BossGroup专门负责接收客户端的连接, WorkerGroup专门负责网络的读写。
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(bossGroup,workerGroup)
                // NioServerSocketChannel将此管道设置为服务器端
                .channel(NioServerSocketChannel.class);
                // BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，
                //用于临时存放已完成三次握手的请求的队列的最大长度。如果未设置或所设置的值小于1，Java将使用默认值50。(没有懂)
               // .option(ChannelOption.SO_BACKLOG,100).childHandler(new );


    }
    public static void main(String[] args) {

    }
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
          //  ch.pipeline().addLast(new )
        }
    }

}
