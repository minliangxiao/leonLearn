package com.example.learn.mq.mqbyworkmq;

import com.example.learn.mq.mqbymaven.RabbitMQConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    // 已经创建好的队列
    private static  final String QUEUE_NAME = "growp_queue";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 1.获取连接
        Connection connection = RabbitMQConnection.getConnection();
        // 2. 创建通道
        Channel channel = connection.createChannel();
        // 将当前通道设置成confirm模式
        for (int i = 0; i < 10; i++) {
            String msg= "生产者消息i："+i;
            // basicPublish第一个参数是交换机
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }
        System.out.println("消息投递成功");
        // 3.关闭资源
        channel.close();
        connection.close();
    }
}
