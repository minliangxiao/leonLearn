package com.example.alip6.threadAndConcurrent.ApiDemo;

public class WaitAndNotifyDemo1 {
    private String lock = "lock";
    public static void main(String[] args) throws InterruptedException {
        new WaitAndNotifyDemo1().print();
    }

    private void print() throws InterruptedException {
        /*
         * wait() 释放锁资源，同时当前线程会阻塞
         * wait() 必须获取到锁资源且是当前线程锁资源的锁 不然会报异常
         * notify()唤醒在对象锁上等待的线程，使其从main()方法返回，而返回的前提必须是该线程也获取到对象锁
         * 总结 wait() notify()需要放在synchronized代码块里面
         * */
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+">1<");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+">2<");
            }
        }).start();

        try {
            Thread.sleep(3000);
            synchronized (lock) {
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
