package com.example.learn.mq.base;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 多线程实现队列模型
 */
public class ThreadMQ {
    private static LinkedBlockingDeque<JSONObject> msgs = new LinkedBlockingDeque<JSONObject>();

    public static void main(String[] args) {
        // 生产者
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    JSONObject data = new JSONObject();
                    data.put("userId", "1234");
                    msgs.offer(data);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者线程");
        producer.start();

        Thread consumer = new Thread(() -> {
            while (true) {
                JSONObject data = msgs.poll();
                if (data != null) {
                    System.out.println(Thread.currentThread().getName() + "," + data);
                }
            }
        }, "消费者线程");
        consumer.start();
    }
}
