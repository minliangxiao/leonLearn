package com.example.learn.netty.netty.example2.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义解码器
 */
public class CalcDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 读取请求头，定义的是4个字节，不够的话直接返回等待下一次报文
         if (in.readableBytes()<4){
             return;
         }
        //readInt()方法就是读取4个byte并转成int
        int contentLength = in.readInt();
        //如果剩余可读的字节数比请求体长度小，还原ByteBuf下标等待下一次请求报文
        if (in.readableBytes() < contentLength) {
            in.readerIndex(in.readerIndex() - 4);
            return;
        }
        //读取请求体
        byte[] content = new byte[contentLength];
        in.readBytes(content);
        //使用正则进行匹配,解析请求体并转换成对象
        Pattern pattern = Pattern.compile("^(\\d+)([+\\-*/])(\\d+)$");
        Matcher matcher = pattern.matcher(new String(content));
        if (matcher.find()) {
            int num1 = Integer.valueOf(matcher.group(1));
            String symbol = matcher.group(2);
            int num2 = Integer.valueOf(matcher.group(3));
            CalcBean calcBean = new CalcBean();
            calcBean.setNum1(num1);
            calcBean.setNum2(num2);
            calcBean.setSymbol(symbol);
            System.out.println("接收到请求体：" + calcBean.toString());
            out.add(calcBean);
        }
    }
}
