package com.example.alip6.threadAndConcurrent;//package com.example.alip6.ThreadAndConcurrent;

/**
 * 线程同步实现生产者消费者模型
 * 生产一个对象就消费一个对象
 * 考验点 线程安全问题  线程间的通信 synchronized notify wait
 */
public class ConsumerAndServiceDemo {
    static class Res{
        public String userName;
        public char sex;
        // false 生产 true消费
        public boolean flag =false;
    }

    /**
     * 输入线程 生产者
     */
    static class InputThread extends Thread {
        private  Res res;

        public InputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            int count = 0;
            while (true){

                synchronized (res){
                    if (res.flag){
                        try {
                            // 重点
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0){
                        res.userName = "growpyb";
                        res.sex = '男';
                    }else {
                        res.userName = "成长的yb";
                        res.sex = '女';
                    }
                    count = (count + 1) % 2;
                    res.flag = true;
                    // 唤醒消费者消费 重点
                    res.notify();
                }
            }
        }
    }

    /**
     * 输出线程  消费者
     */
    static class OutPutThread extends Thread{
        private Res res;

        public OutPutThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true){
                synchronized (res){
                    if (!res.flag){
                        try {
                            // 阻塞让生产者生产 重点
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(res.userName+","+res.sex);
                    res.flag = false;
                    // 重点
                    res.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutPutThread outPutThread = new OutPutThread(res);
        inputThread.start();
        outPutThread.start();
    }
}
