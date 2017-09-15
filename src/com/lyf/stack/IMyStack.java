package com.lyf.stack;

/**
 * Created by fangjiejie on 2017/4/13.
 */
public interface IMyStack<T> {
    void push(T o);
    T pop();
    T peek();
    int length();
    void clear();
    boolean isEmpty();
    void resize();
}
class MyStack<T> implements IMyStack<T>{
    private Object array[];
    private int count;
    MyStack(){
        array=new Object[5];
        count=-1;
    }
    @Override
    public void push(T o) {
        if(length()==array.length)
        {
              resize();
        }
        array[++count]=o;
    }

    @Override
    public T pop() {
        Object elem=null;
        if(!isEmpty()){
            elem=array[count];
            array[count--]=null;
        }
        return (T)elem;
    }

    @Override
    public T peek() {
        Object elem=null;
        if(!isEmpty()){
            elem=array[count];
        }
        return (T)elem;
    }

    @Override
    public int length() {
        return count+1;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            array[count--]=null;
        }
    }

    @Override
    public boolean isEmpty() {
        return count==-1;
    }

    @Override
    public void resize() {
        Object []newArray=new Object[array.length*2];
        for(int i=0;i<array.length;i++){
            newArray[i]=array[i];
        }
        array=newArray;
        System.out.println("数组长度不够，已扩充为"+array.length);
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack=new MyStack<>();
        myStack.push(5);
        myStack.push(4);
        myStack.push(8);
        myStack.push(40);
        myStack.push(12);
        myStack.push(60);
        myStack.push(87);
        myStack.push(1);
        myStack.push(66);
        System.out.println(myStack.length());
        myStack.pop();
        System.out.println(myStack.length());
        myStack.clear();
        System.out.println(myStack.length());
    }
}
