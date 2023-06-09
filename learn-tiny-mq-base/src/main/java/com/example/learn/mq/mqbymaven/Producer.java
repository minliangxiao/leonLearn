package com.example.learn.mq.mqbymaven;

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
        String msg = "这是一条消息";
        // 将当前通道设置成confirm模式
        channel.confirmSelect();
        // 事物消息
       // channel.txSelect();
        try {
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
          //  channel.txCommit();
            //channel.close();
        }catch ( Exception e){
            if (channel!=null) {
              //  channel.txRollback();
            }

        }

        // 这个方法是同步的 生成者等消息投递到服务器之后才会进行
        boolean b = channel.waitForConfirms();
        if (b) {
            System.out.println("消息发送到mq服务器");
        }else {
            System.out.println("消息投递失败");
        }

        // 3.关闭资源
        channel.close();
        connection.close();
    }
}
