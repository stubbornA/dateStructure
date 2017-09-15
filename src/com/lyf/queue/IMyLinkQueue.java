package com.lyf.queue;

/**
 * Created by fangjiejie on 2017/4/13.
 */
public interface IMyLinkQueue<T> {
    int length();
    T remove();
    void add(T elem);
    boolean empty();
    T elment();
    void clear();
}
class MyLinkQueue<T> implements IMyLinkQueue<T>{
    class Node{
        T date;
        Node next;
        public Node(T date, Node next) {
            this.date = date;
            this.next = next;
        }
    }
    private Object []array;
    private int count=0;
    private Node front;
    private Node rear;

    public MyLinkQueue(T elem) {
        Node newNode=new Node(elem,null);
        this.rear=newNode;
        this.front=newNode;
        count++;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public T remove() {
        T elem=null;
        if(!empty()){
            Node oldfront=front;
            elem=oldfront.date;
            front=front.next;
            oldfront=null;
        }
        count--;
        return elem;
    }

    @Override
    public void add(T elem) {
        Node newNode=new Node(elem,null);
        if(length()==0){
            this.front=newNode;
            this.rear=newNode;
        }else{
            this.rear.next=newNode;
            this.rear=newNode;
        }
        count++;
    }

    @Override
    public boolean empty() {
        return count==0;
    }

    @Override
    public T elment() {
        T elem=null;
        if(!empty()){
            elem=front.date;
        }
        return elem;
    }

    @Override
    public void clear() {
       while(!empty()){
           remove();
       }
    }
    public String toString(){
        StringBuffer sb=new StringBuffer("");
        for(Node tmpNode=front;tmpNode!=rear;tmpNode=tmpNode.next){
          sb=sb.append(tmpNode.date);
        }
        return sb.toString();
    }
}














//class MyLinkQueue<T> implements IMyLinkQueue<T>{
//    class Node{
//        private T data;
//        private Node next;
//
//        public Node(T data, Node next) {
//            this.data = data;
//            this.next = next;
//        }
//    }
//    private int count=0;
//    private Node front;
//    private Node rear;
//    public MyLinkQueue(T elem) {
//        this.front=new Node(elem,null);
//        this.rear=this.front;
//        count++;
//    }
//
//    @Override
//    public int length() {
//        return this.count;
//    }
//
//    @Override
//    public T remove() {
//        Node oldFront=front;
//        front=front.next;
//        oldFront.next=null;
//        count--;
//        return oldFront.data;
//    }
//
//    @Override
//    public void add(T elem) {
//        count++;
//        if(this.length()==0){
//            Node newNode=new Node(elem,null);
//            this.rear=newNode;
//            this.front=newNode;
//        }else{
//            Node newNode=new Node(elem,null);
//            rear.next=newNode;//当前尾部节点的next指向该新创建的节点
//            this.rear=newNode;//队列的尾部换为新添加的节点
//        }
//    }
//
//    @Override
//    public boolean empty() {
//        return count==0;
//    }
//
//    @Override
//    public T elment() {
//        T elem=null;
//        if(!empty()){
//            elem=rear.data;
//        }
//        return elem;
//    }
//
//    @Override
//    public void clear() {
//        this.count=0;
//        this.front=null;
//        this.rear=null;
//    }
//    public String toString(){
//        StringBuffer sb=new StringBuffer("");
//        if(empty()){
//            return null;
//        }
//        else {
//            for (Node n = front; n != null; n = n.next) {
//                sb.append(n.data.toString() + ",");
//            }
//            return sb.toString();
//        }
//    }
//}
class TestMyLinkqueue{
    public static void main(String[] args) {
        MyLinkQueue<String> myLinkQueue=new MyLinkQueue<>("111");
        myLinkQueue.add("222");
        myLinkQueue.add("333");
        myLinkQueue.add("444");
        myLinkQueue.add("555");
        myLinkQueue.add("666");
        System.out.println(myLinkQueue.length());
        System.out.println(myLinkQueue.elment());
        myLinkQueue.remove();
        System.out.println(myLinkQueue.toString());
        myLinkQueue.clear();
        System.out.println(myLinkQueue.empty());
    }
}
