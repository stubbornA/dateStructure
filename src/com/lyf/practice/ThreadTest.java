package com.lyf.practice;

/**
 * Created by fangjiejie on 2017/4/23.
 */
public class ThreadTest {
    private class Business{
        boolean bShouldSub=true;
        public synchronized void MainThread(int i){
            if(bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int j=0;j<5;j++){
                    System.out.println("主线程"+i+"循环第"+j+"次");
                }
                bShouldSub=true;
                this.notify();
            }
        }
        public synchronized void SubThread(int i){
            if(!bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<10;j++){
                System.out.println("子线程"+i+"循环第"+j+"次");
            }
            bShouldSub=false;
            this.notify();
        }
    }
    public static void main(String[] args) {
        new ThreadTest().init();
    }
    public void init(){
        final Business business=new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                    business.SubThread(i);
                }
            }
        }).start();

                for(int i=0;i<50;i++){
                    business.MainThread(i);
                }

    }
}

