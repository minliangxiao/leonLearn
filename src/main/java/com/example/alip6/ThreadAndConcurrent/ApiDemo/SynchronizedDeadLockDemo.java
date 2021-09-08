package com.example.alip6.threadAndConcurrent.ApiDemo;

/**
 * Synchroized 造成死锁的案例分析
 *
 */
public class SynchronizedDeadLockDemo  implements Runnable{
    private int count = 1;
    private String lock = "lock";
    @Override
    public void run() {
        while (true){
            count++;
            if (count % 2 == 0){
                synchronized (lock){
                    a();
                }
            }else {
                synchronized (this){
                    b();
                }
            }
        }
    }

    private synchronized void a() {
        System.out.println(Thread.currentThread().getName()+ ",a方法....");
    }
    private void b() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+ ",b方法.....");
        }
    }

    public static void main(String[] args) {
        SynchronizedDeadLockDemo synchronizedDeadLockDemo = new SynchronizedDeadLockDemo();
        new Thread(synchronizedDeadLockDemo).start();
        new Thread(synchronizedDeadLockDemo).start();
    }
}
