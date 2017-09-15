package com.lyf.linkList;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/5/14.
 */
public class RemoveLastKthNode<T> {
    public class Node<T>{
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
        public String toString(){
            return value.toString();
        }
    }
    public Node<T> remove(Node head,int lastKth){
        if(head==null||lastKth<1){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){
            head=head.next;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }
    private Node<Integer> head;
    @Test
    public  void test() {
        Node<Integer> []nodes=new Node[10];
        for(int i=0;i<10;i++){
            nodes[i]=new Node<>(i+10);
            if(i==0){
                head=nodes[i];
            }else{
                nodes[i-1].next=nodes[i];
            }
        }
        for(int i=0;i<10;i++){
            System.out.print(nodes[i].toString()+",");
        }
        System.out.println();
        Node<Integer> tmp=(Node<Integer>)remove(head,3);
        while(tmp!=null){
            System.out.print(tmp.toString()+",");
            tmp=tmp.next;
        }
    }
}
