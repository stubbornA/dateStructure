package com.lyf.queue;

import java.util.Arrays;

/**
 * Created by fangjiejie on 2017/4/14.
 */
public interface IMyLoopQueue<T>{
    int length();
    T remove();
    void add(T elem);
    boolean empty();
    T elment();
    void clear();
}
 class MyLoopQueue<T> implements IMyLinkQueue<T>{
     int capicity;
     int front;
     int rear;
     Object []array;

     public MyLoopQueue(int cap,T initElem) {
         this.capicity=cap;
         this.array=new Object[capicity];
         this.front=0;
         this.rear=0;
         array[front]=initElem;
         rear++;
     }
     @Override
    public int length() {
         if(empty()) {
             return 0;
         }else{
             return rear>front?rear-front:capicity-(front-rear);
         }
    }

    @Override
    public T remove() {
        T elem=null;
        if(empty()){
            throw new NullPointerException("队列为空");
        }else{
            elem=(T)array[front++];
            front=front==capicity?0:front;
        }
        return elem;
    }

    @Override
    public void add(T elem) {
        if(front==rear&&array[front]!=null){
            throw new IndexOutOfBoundsException("队列已满！");
        }else{
            array[rear++]=elem;
            rear=rear==capicity?0:rear;
        }
    }

    @Override
    public boolean empty() {
        return front==rear&&array[front]==null;
    }

    @Override
    public T elment() {
        T elem=null;
        if(!empty())
        {
            elem=(T)array[front];
        }
        return elem;
    }

    @Override
    public void clear() {
        Arrays.fill(array,null);
        front=0;
        rear=0;
    }
     public String toString(){
         StringBuffer sb=new StringBuffer("");
         if(rear>front)
         {
             for(int i=front;i<rear;i++){
                 sb=sb.append(array[i]+",");
             }
         }
         else{
             for(int i=front;i<capicity;i++){
                 sb.append(array[i]+",");
             }
             for(int i=0;i<rear;i++){
                 sb.append(array[i]+",");
             }
         }
         return sb.toString();
     }
}
class TestMyLoopQueue{
    public static void main(String[] args) {
       MyLoopQueue<String> myLoopQueue=new MyLoopQueue<>(5,"AAA");
        myLoopQueue.add("BBB");
        myLoopQueue.add("CCC");
        myLoopQueue.add("DDD");
        System.out.println(myLoopQueue.toString()+ myLoopQueue.length());
        myLoopQueue.remove();
        System.out.println(myLoopQueue.toString()+ myLoopQueue.length());
        myLoopQueue.add("EEE");
        myLoopQueue.add("FFF");
        System.out.println(myLoopQueue.toString()+ myLoopQueue.length());
        myLoopQueue.remove();
        myLoopQueue.add("GGG");
        System.out.println(myLoopQueue.toString()+ myLoopQueue.length());
        System.out.println(myLoopQueue.elment());


    }
}
