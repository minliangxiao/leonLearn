package com.example.learn.mq.mqbymaven;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    // 已经创建好的队列
    private static  final String QUEUE_NAME = "growp_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.获取连接
        Connection connection = RabbitMQConnection.getConnection();
        // 2. 创建通道
        Channel channel = connection.createChannel();
        String msg = "这是一条消息";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        // 3.关闭资源
        channel.close();
        connection.close();
    }
}
