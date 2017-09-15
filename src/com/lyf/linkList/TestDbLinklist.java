package com.lyf.linkList;

/**
 * Created by fangjiejie on 2017/4/18.
 */
public class TestDbLinklist<T> {
    class Node{
        T data;
        Node prev;
        Node next;

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    Node head;
    Node tail;
    int size;

    public TestDbLinklist() {
        this.head = new Node(null,null,null);
        this.tail = new Node(null,null,null);
        size=0;
    }

    public int length(){
        return size;
    }
    public T get(int index){
        return getNodeByIndex(index).data;
    }
    private Node getNodeByIndex(int index){
        Node node=null;
        if(empty()){
            throw new NullPointerException("链表为空！");
        }
        else if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("链表越界！");
        }else if(index<=size/2){
            Node tmpN=head;
            for(int i=0;i<=size/2;i++,tmpN=tmpN.next)
            {
                if(i==index){
                    node=tmpN;
                    break;
                }
            }
        }else{
            Node tmpN=tail;
            for(int i=size-1;i>size/2;i++,tmpN=tmpN.prev){
                if(i==index){
                    node=tmpN;
                    break;
                }
            }
        }
        return node;
    }
    public int findElement(T elem){
        if(empty()){
            throw new NullPointerException("链表为空！");
        }else{
            int i=0;
            for(Node node=head;node!=null;node=node.next,i++){
                if(node.data.equals(elem)){
                    return i;
                }
            }
        }
        return -1;
    }
    public void insert(T element , int index){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("链表越界！");
        }else if(empty()||index==0){
          addHeader(element);
        }else {
            Node prev=getNodeByIndex(index-1);
            Node next=prev.next;
            Node newNode=new Node(element,prev,next);
            prev.next=newNode;
            next.prev=newNode;
            size++;
        }
    }
    public void addTail(T element){
        Node newNode=null;
        if(empty()){
            head=new Node(element,null,null);
            tail=head;
        }else{
            Node oldtail=tail;
            newNode=new Node(element,oldtail,null);
            oldtail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public void addHeader(T element){
        Node newNode=null;
        if(empty()){
            head=new Node(element,null,null);
            tail=head;
        }else{
            Node oldhead=head;
            newNode=new Node(element,null,head);
            oldhead.prev=newNode;
            head=newNode;
        }
        size++;
    }
    public T delete(int index){
        Node del=null;
        if(index<1||index>size){
            throw new ArrayIndexOutOfBoundsException("链表越界！");
        }else if(index==0){
            del=head;
            head=head.next;
            head.prev=null;
        }else{
            Node preNode=getNodeByIndex(index-1);
            del=preNode.next;
            Node nexNode=del.next;
            if(nexNode!=null){
                nexNode.prev=preNode;
            }
            preNode.next=nexNode;
            del.next=null;
            del.prev=null;
        }
        size--;
        return del.data;
    }
    public T remove(){
        return delete(size-1);
    }
    public boolean empty(){
        return size==0;
    }
    public void clear(){
        head=null;
        tail=null;
        size=0;
    }
    public String toString(){
        StringBuffer sb=new StringBuffer("");
        for(Node tmp=head;tmp!=null;tmp=tmp.next){
            sb=sb.append(tmp.data+" ");
        }
        return sb.toString();
    }
    public String reverseToString(){
        StringBuffer sb=new StringBuffer("");
        for(Node tmp=tail;tmp!=null;tmp=tmp.prev){
            sb=sb.append(tmp.data+" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestDbLinklist<String> dbLinklist=new TestDbLinklist<>();
        dbLinklist.addTail("zzz");
        dbLinklist.addTail("yyy");
        dbLinklist.addTail("xxx");
        dbLinklist.addHeader("haoba");
        System.out.println(dbLinklist.toString());
        dbLinklist.insert("hhh",1);
        System.out.println(dbLinklist.toString());
        dbLinklist.delete(2);
        System.out.println(dbLinklist.toString());
        System.out.println(dbLinklist.findElement("yyy"));
        System.out.println(dbLinklist.findElement("kkk"));
        System.out.println(dbLinklist.get(1));
        System.out.println(dbLinklist.reverseToString());
        dbLinklist.clear();
        System.out.println(dbLinklist.reverseToString()+"----------");

    }
}

