package com.example.learn.mq.mqbyworkmq;

import com.example.learn.mq.mqbymaven.RabbitMQConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    private static  final String QUEUE_NAME = "growp_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        Channel channel = connection.createChannel();
        //参数代表消费者每次可以从队列里面每次获取到几条消息
        channel.basicQos(2);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
             String msg = new String(body, "UTF-8");
                System.out.println("消费者获取消息："+msg);
                // 向mq服务器发送确认
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        // 监听队列
        channel.basicConsume(QUEUE_NAME,false,defaultConsumer);

    }
}
