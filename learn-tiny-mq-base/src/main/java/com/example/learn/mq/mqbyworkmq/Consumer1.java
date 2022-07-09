package com.example.learn.mq.mqbyworkmq;

import com.example.learn.mq.mqbymaven.RabbitMQConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    private static  final String QUEUE_NAME = "growp_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        Channel channel = connection.createChannel();
        //参数代表消费者每次可以从队列里面每次获取到几条消息
        channel.basicQos(1);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String msg = new String(body, "UTF-8");
                System.out.println("消费者获取消息："+msg);
                // 向mq服务器发送确认  如果没有向mq服务器发送ack那么消息不会从队列里删除 队列也不会再排新到队列过来
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        // 监听队列
        channel.basicConsume(QUEUE_NAME,false,defaultConsumer);

    }
}
