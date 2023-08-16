package com.example.learn.netty.netty.example2.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

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
        //拿到上一个handle返回的对象
        CalcBean calcBean = (CalcBean) msg;
        double result = 0;
        double num1 = calcBean.getNum1();
        double num2 = calcBean.getNum2();
        //分配一个ByteBuf对象
        ByteBuf response = Unpooled.buffer();
        //根据符号进行相应的计算
        switch (calcBean.getSymbol()) {
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
        //将计算结果写入到ByteBuf中
        response.writeBytes((result + System.lineSeparator()).getBytes());
        //把消息返回到客户端
        ctx.writeAndFlush(response);
    }
}
