package com.lyf.linkList;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/5/17.
 */
public class RemoveMidNode<T> {
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
    public Node<T> removeMid(Node head){//删除中间节点就是要找到中间结点的前一个节点
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        Node<T> cur1=head;
        Node<T> cur2=cur1.next;
        while(cur2.next!=null&&cur2.next.next!=null){
            cur1=cur1.next;//cur1以一倍的速度向后移动。
            cur2=cur2.next.next;//cur2以二倍的速度向后移动。当cur2到达末尾时候,cur1也就达到了整个链表中间位置的前一个节点
        }
        cur1.next=cur1.next.next;
        return head;
    }
    public Node<Integer> head;
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
        Node<Integer> tmp=(Node<Integer>)removeMid(head);
        while(tmp!=null){
            System.out.print(tmp.toString()+",");
            tmp=tmp.next;
        }
    }
}
