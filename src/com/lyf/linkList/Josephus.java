package com.lyf.linkList;

/**
 * Created by fangjiejie on 2017/4/19.
 */
public class Josephus{
    int n;//共有n个人
    int m;//数到m淘汰
    Node head=null;
    Node tail=null;
    class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public Josephus(int n, int m) {
        this.n = n;
        this.m = m;
        Node tmp= new Node(1,null);
        this.head=tmp;
        for(int i=2;i<=n;i++){
            tmp.next=new Node(i,null);
            tmp=tmp.next;
        }
        tail=tmp;
        tmp.next=head;
    }
    public Node  Kill(){
        int count=0;
        while(head!=tail){//循环链表中，当head==tail，且不为空，则只剩下一个节点
            if(++count==m){//如果报数为m，那么此时的head淘汰
                System.out.print("kill "+head.data+", ");
                tail.next=head.next;
                count=0;
            }else{
                tail=tail.next;//tail 一直定位在被淘汰的人的前一个位置
            }
            head=head.next;//head 定位在重新开始报数的人的位置，
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("最后剩下了"+new Josephus(15,3).Kill().data);
        System.out.println("最后剩下了"+new Josephus(17,3).Kill().data);
        System.out.println("最后剩下了"+new Josephus(41,3).Kill().data);
    }
}
