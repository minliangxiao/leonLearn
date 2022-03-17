package com.example.alip6.ThreadAndConcurrent.ApiDemo;

/**
 * 停止线程的方法 但是这个方法不是绝对 还有二阶段停止线程这里就不写了 下来自己查资料
 */
public class StopThread extends Thread{
    @Override
    public void run() {
        while (true){
            if (this.isInterrupted()){
                break;
            }
        }
        System.out.println(Thread.currentThread().getName()+": 子线程停止了");
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        stopThread.interrupt();
        System.out.println(Thread.currentThread().getName()+":----子线程已经停止了");
    }
}
