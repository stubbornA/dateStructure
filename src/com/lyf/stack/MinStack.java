package com.lyf.stack;

import java.util.Stack;

/**
 * Created by fangjiejie on 2017/4/13.
 */
public class MinStack {
    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();

    public MinStack() {
    }

    public MinStack(Stack<Integer> stack, Stack<Integer> minStack) {
        this.stack = stack;
        this.minStack = minStack;
    }
    public void push(int i){
        stack.push(i);
        if(minStack.empty()||i<minStack.peek()){
            minStack.push(i);
        }
    }
    public int pop(){
        int p=stack.peek();
        if(!stack.empty()&&stack.pop()==minStack.peek()){
            minStack.pop();
        }
        return p;
    }
    public boolean empty(){
        return stack.empty();
    }
    public Integer getMin(){
        if(minStack.empty()){
           System.out.println("栈为空！");
            return null;
        }
        else{
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack mstack=new MinStack();
        mstack.push(9);
        mstack.push(6);
        mstack.push(7);
        mstack.push(8);
        mstack.push(4);
        mstack.push(8);
        mstack.push(3);
        mstack.push(10);
        System.out.println("1:min-------"+mstack.getMin());
        mstack.pop();
        mstack.pop();
        System.out.println("2:min-------"+mstack.getMin());
        mstack.pop();
        mstack.pop();
        System.out.println("3:min-------"+mstack.getMin());
        mstack.pop();
        System.out.println("4:min-------"+mstack.getMin());
        mstack.pop();
        System.out.println("5:min-------"+mstack.getMin());
    }
}
