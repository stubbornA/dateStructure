package com.lyf.queue;

import java.util.Arrays;

/**
 * Created by fangjiejie on 2017/4/13.
 */
public interface IMySequenceQueue<T>{
    int length();
    T remove();
    void add(T elem);
    boolean empty();
    T elment();
    void clear();
}
class MySequenceQueue<T> implements IMySequenceQueue<T>{
    private Object []array;
    private int DEFAULT_SIZE=10;
    private int capacity;
    private int front;
    private int rear;

    public MySequenceQueue() {
        this.capacity=DEFAULT_SIZE;
        this.array=new Object[capacity];
        this.front=0;
        this.rear=0;
    }

    @Override
    public int length() {
        return rear-front;
    }

    @Override
    public T remove() {
        T elem=null;
        if(length()==0){
            throw new NullPointerException("队列为空！");
        }else{
            elem=(T)array[front];
            array[front++]=null;
        }
        return elem;
    }

    @Override
    public void add(T elem) {
        if(length()==array.length){
            throw new IndexOutOfBoundsException("队列已满！");
        }else{
            array[rear++]=elem;
        }
    }

    @Override
    public T elment() {
        T elem=null;
        if(length()==0){
            throw new NullPointerException("队列为空！");
        }else{
            elem=(T)array[front];
        }
        return elem;
    }

    @Override
    public boolean empty() {
        return length()==0;
    }

    @Override
    public void clear() {
        Arrays.fill(array,null);
        front=0;
        rear=0;
    }
    public String toString(){
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<length();i++){
            sb.append(array[i]+",");
        }
        return sb.toString();
    }
}
class TestMySequenceQueue{
    public static void main(String[] args) {
        MySequenceQueue<String> myQueue=new MySequenceQueue<String>();
        myQueue.add("AAA");
        myQueue.add("BBB");
        myQueue.add("CCC");
        myQueue.add("DDD");
        System.out.println(myQueue.toString());
        System.out.println(myQueue.length());
        System.out.println(myQueue.elment());
        myQueue.clear();
        System.out.println(myQueue.empty());
    }
}
