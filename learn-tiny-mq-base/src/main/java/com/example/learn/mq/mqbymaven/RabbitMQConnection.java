package com.example.learn.mq.mqbymaven;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQConnection {
    /*
    * 获取连接
    * */
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/learn");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        // 3.mq连接信息地址
        connectionFactory.setHost("127.0.0.1");
        // 这个需要用rabbitmq开放的amqp地址
        connectionFactory.setPort(5672);
        return connectionFactory.newConnection();
    }
}
