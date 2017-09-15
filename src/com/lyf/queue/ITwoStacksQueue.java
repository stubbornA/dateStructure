package com.lyf.queue;

import java.util.Stack;

/**
 * Created by fangjiejie on 2017/4/15.
 */
public interface ITwoStacksQueue {
    void add(int elem);
    int poll();
    int peek();
}
class TwoStacksQueue implements ITwoStacksQueue{
    private Stack<Integer> pushStack=new Stack<>();
    private Stack<Integer> pollStack=new Stack<>();

    public TwoStacksQueue() {
    }

    @Override
    public void add(int elem) {
        pushStack.push(elem);
    }

    @Override
    public int poll() {
        if(pushStack.empty()&&pollStack.empty()){
            throw new NullPointerException("队列为空");
        }else if(pollStack.empty()){
            while(!pushStack.empty()){
                pollStack.push(pushStack.pop());
            }
        }
        return pollStack.pop();
    }

    @Override
    public int peek() {
        if(pushStack.empty()&&pollStack.empty()){
            throw new NullPointerException("队列为空");
        }else if(pollStack.empty()){
            while(!pushStack.empty()){
                pollStack.push(pushStack.pop());
            }
        }
        return pollStack.pop();
    }
}
class TestTwoStacksQueue{
    public static void main(String[] args) {
        TwoStacksQueue queue=new TwoStacksQueue();
        for(int i=0;i<10;i++){
            queue.add(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(queue.poll());
        }
    }
}

