package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.ApiDemo;

/**
 * 从字节码层面理解join无法保证共享变量线程安全  结合笔记的截图看
 */
public class Practice extends Thread{
    private static Integer  sum = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            sum++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Practice practice = new Practice();
        Practice practice1 = new Practice();
        practice.start();
        practice1.start();
        practice.join();
        practice1.join();
        System.out.println(sum);
    }
}
