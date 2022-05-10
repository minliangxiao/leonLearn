package com.example.learn.netty.netty.example2.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 自定义编码器
 */
public class CalcEncoder extends MessageToByteEncoder<CalcBean> {
    @Override
    protected void encode(ChannelHandlerContext ctx, CalcBean msg, ByteBuf out) throws Exception {
        byte[] content = (msg.getNum1() + msg.getSymbol() + msg.getNum2()).getBytes();
        //输出请求头，writeInt()是写4个byte
        out.writeInt(content.length);
        //输出请求体
        out.writeBytes(content);
    }
}
