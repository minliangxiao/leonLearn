package com.example.learn.concurrent.LearnConcurrent.ThreadPool;

import java.util.concurrent.*;

/**
 * [线程池案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/12 10:11]
 */

/***
 * 1、提前创建好固定的线程一直在运行状态---死循环实现
 * 2、提交的线程任务缓存到一个并发容器中。
 * 3、正在运行的线程，去并发容器里拿相应的任务执行。
 */
public class MyTreadPoolEg {
    /**
     * 装线程的队列
     */
//    private List<WorkTread> workTreads;

    /**
     * 并发容器
     */
    private BlockingDeque<Runnable> runnables;

    private boolean isRun = true;
    /**
     * @param maxThreadCount 最大线程数
     */
    public MyTreadPoolEg(int maxThreadCount,int deuqeSize){
        runnables = new LinkedBlockingDeque<Runnable>(deuqeSize);
//        workTreads = new ArrayList<WorkTread>(maxThreadCount);
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkTread().start();
        }
    }

    class WorkTread extends Thread{
        @Override
        public void run() {
            while (isRun||runnables.size()>0){
                Runnable runnable = runnables.poll();
                if (runnable!=null) {
                    runnable.run();
                }
            }
        }
    }

    public boolean execute(Runnable command){
        return runnables.offer(command);
    }

    public static void main(String[] args) {
        MyTreadPoolEg myTreadPoolEg = new  MyTreadPoolEg(2,2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myTreadPoolEg.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+","+ finalI);
                }
            });
        }
        myTreadPoolEg.isRun = false;


    }
}
