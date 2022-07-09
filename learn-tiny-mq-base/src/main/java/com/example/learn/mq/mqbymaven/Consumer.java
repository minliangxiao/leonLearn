package com.example.learn.mq.mqbymaven;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    private static final String QUEUE_NAME = "growp_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接
        Connection connection = RabbitMQConnection.getConnection();
        // 2.设置通道
        Channel channel = connection.createChannel();
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("消费者获取到消息:"+msg);
                // 消费者完成  消费者给mq服务器发送通知删除该条消息
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };
        // 3.监听队列
        // basicComsume第二个参数代表应答模式  false代表手动应答  true代表自动签收模式
        // 手动应答模式代表着你必须要告诉mq你已经消费成功了 like channel.basicAck(envelope.getDeliveryTag(), false);

        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);

    }
}
