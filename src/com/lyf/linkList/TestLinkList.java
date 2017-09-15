package com.lyf.linkList;

/**
 * Created by fangjiejie on 2017/4/15.
 */
public class TestLinkList <T>{
    Node head;
    Node tail;
    int size;

    public TestLinkList() {
        head=null;
        tail=null;
    }

    public int length(){
        return size;
    }
    public Node getNodeByIndex(int index){
        Node node=null;
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("线性表越界");
        }else{
            Node tmpNode=head;
            int i=0;
            while(tmpNode!=null){
                if(i==index){
                    node=tmpNode;
                    break;
                }
                i++;
                tmpNode=tmpNode.next;
            }
        }
          return node;
    }
    public int findElement(T element){
        Node tmpNode=head;
        if(tmpNode!=null){
            for(int i=0;i<size;i++){
                if(tmpNode.data.equals(element)){
                    return i;
                }
                tmpNode=tmpNode.next;
            }
        }
        return -1;
    }
    public void addTail(T element){
        Node newNode=new Node(element,null);
         if(empty()){
             head=newNode;
             tail=newNode;
         }else{
             tail.next=newNode;
             tail=newNode;
         }
        size++;
    }
    public void addHeader(T element){
/*        if(empty()){
            tail=newNode;
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        size++;*/
        head=new Node(element,head);
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insert(T element,int index){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("线性表越界");
        }else if(empty()||index==0){
            addHeader(element);
        }else{
            Node prevNode=getNodeByIndex(index-1);
            prevNode.next=new Node(element,prevNode.next);
            size++;
        }
    }
    public T delete(int index){
        Node oldNode=null;
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("线性表越界");
        }else if(empty()){
            throw new NullPointerException("线性表为空");
        }else if(index==0){
            oldNode=head;
            head=head.next;
        }else {
            Node prev=getNodeByIndex(index-1);
            oldNode=prev.next;
            prev.next=oldNode.next;
        }
        size--;
        return (T)oldNode.data;
    }
    public boolean empty(){
          return size==0;
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public String toString(){
        if (empty()){
            return "[]";
        }
        else{
            StringBuilder sb = new StringBuilder();
            for (Node current = head; current != null; current = current.next ){
                sb.append(current.data.toString() + ", ");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        TestLinkList <Integer> linkList=new TestLinkList<>();
        linkList.addTail(1);
        linkList.addTail(2);
        linkList.addTail(3);
        linkList.addTail(4);
        linkList.addTail(5);
        System.out.println(linkList.toString());
        linkList.addHeader(0);
        System.out.println(linkList.toString());
        linkList.insert(10,2);
        System.out.println(linkList.toString());
        System.out.println(linkList.findElement(10));
        linkList.delete(2);
        System.out.println(linkList.toString());
        System.out.println(linkList.findElement(3));
        System.out.println(linkList.length());
        linkList.clear();
        System.out.println(linkList.toString());
    }
}
class Node<T>{
    T data;
    Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    public T getData() {
        return data;
    }
}
class FindOrderLinkListCommonPart{
    private Node<Integer> head1;
    private Node<Integer> head2;
    StringBuffer sb=null;
    public FindOrderLinkListCommonPart(Node<Integer> head1, Node<Integer> head2) {
        this.head1 = head1;
        this.head2 = head2;
        sb=new StringBuffer("");
    }

    public void printCommonPart( ){
        System.out.println("the CommonPart as:");
        while(head1!=null&&head2!=null){
            if(head1.data>head2.data){
                head2=head2.next;
            }else if(head1.data<head2.data){
                head1=head1.next;
            }else{
                sb=sb.append(head1.data+"  ");
                head1=head1.next;
                head2=head2.next;
            }
        }
    }

    @Override
    public String toString() {
        printCommonPart();
        return sb.toString();
    }

    public static void main(String[] args) {
        TestLinkList<Integer> l1=new TestLinkList<>();
        l1.addTail(2);
        l1.addTail(5);
        l1.addTail(6);
        l1.addTail(8);
        l1.addTail(9);
        TestLinkList<Integer> l2=new TestLinkList<>();
        l2.addTail(1);
        l2.addTail(5);
        l2.addTail(8);
        l2.addTail(9);
        l2.addTail(10);
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        FindOrderLinkListCommonPart find =new FindOrderLinkListCommonPart(l1.head,l2.head);
        System.out.println(find.toString());
    }
}
