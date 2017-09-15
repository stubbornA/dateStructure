package com.lyf.practice;

/**
 * Created by fangjiejie on 2017/4/24.
 */
public class ThreadTest2 {
    private class Business{
        boolean flag=true;//作为子线程和主线程谁来执行的标志，true为子线程执行，主线程等待
        public synchronized void SubThread(int i){
            if(!flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<10;j++){
                System.out.println("子线程"+i+"执行"+j);
            }
            this.notifyAll();
            flag=false;
        }
        public synchronized void MainThread(int i){
            if(flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<100;j++){
                System.out.println("主线程"+i+"执行"+j);
            }
            this.notifyAll();
            flag=true;
        }
    }
    public void execute(){//主线程子线程轮回执行50次
        final Business business=new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                    business.SubThread(i);
                }
            }
        }).start();
        for(int i=0;i<50;i++){//两个循环只能有一个来用线程启动，否则。如果都用new Thread的方式，
            // 一旦一个线程开启，第二个线程必须等待其完成才能开启，发生了死锁现象。
            business.MainThread(i);
        }
    }
    public static void main(String[] args) {
          new ThreadTest2().execute();
    }

}
