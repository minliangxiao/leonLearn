package com.example.learn.netty.netty.example0.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcServerHandler extends ChannelInboundHandlerAdapter {
    // 当有连接接入时执行这个方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有新的客户端连接至服务器");
    }

    /**
     * @param ctx 可以用它提供的方法写入消息到客户端
     * @param msg 就是接收到的客户端消息，默认是ByteBuf类型,ByteBuf是 netty 提供的类似于 JDK 中 java.nio.ByteBuffer 接口，但它提供了更强大更灵活的功能，是 netty 最原始的通讯单位。
     * @throws Exception
     */
    // 当读取当前通道中的数据时开始执行这个方法
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //拿到客户端传来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        //根据读到的消息长度创建字节数组
        byte[] data = new byte[byteBuf.readableBytes()];
        //把消息读到字节数组中
        byteBuf.readBytes(data);
        //将读到的消息转成字符串
        String body = new String(data, "utf-8");
        System.out.println("接收到计算公式：" + body);
        //分配一个ByteBuf对象
        ByteBuf response = Unpooled.buffer();
        //使用正则表达式匹配出两个数字和计算符号
        Pattern pattern = Pattern.compile("^(\\d+)([+\\-*/])(\\d+)$");
        Matcher matcher = pattern.matcher(body);
        double result = 0;
        if (matcher.find()) {
            double num1 = Double.valueOf(matcher.group(1));
            double num2 = Double.valueOf(matcher.group(3));
            String symbol = matcher.group(2);
            //根据符号进行相应的计算
            switch (symbol) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
        } else {
            System.out.println("计算公式不正确");
        }
        //将计算结果写入到ByteBuf中
        response.writeBytes((result + "").getBytes());
        //把消息返回到客户端
        ctx.writeAndFlush(response);
    }
}
