package com.lyf.queue;

/**
 * Created by fangjiejie on 2017/4/15.
 */
public interface IMyDbQueue <T>{
    T peekHead();
    T peekRear();
    boolean isEmpty();
    void insertFirst(T data);
    void insertLast(T data);
    T deleteHead();
    T deleteRear();
    T find(T t);
    T delete(T t);
    boolean insertAfter(T key,T data);
    int size();
    void displayListSHead();
    void displayListSRear();
}
class MyDbQueue<T> implements IMyDbQueue<T>{
    class Link{
        private T data;
        private Link previous;
        private Link next;
        public Link(T data) {
            this.data = data;
            previous=null;
            next=null;
        }
        public void displayLink() {
            System.out.println("数据是： " + data.toString());
        }
    }
    private Link head;//首节点
    private Link rear;//尾节点

    public MyDbQueue() {
    }

    @Override
    public T peekHead() {
        return isEmpty()?null:head.data;
    }

    @Override
    public T peekRear() {
        return isEmpty()?null:rear.data;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public void insertFirst(T data) {
        Link newLink=new Link(data);
         if(isEmpty()){
             rear=newLink;
         }else{
             head.previous=newLink;//如果在为空的时候执行这句，则会报空指针异常
         }
        newLink.next=head;//********************************??
        head=newLink;

    }

    @Override
    public void insertLast(T data) {
       Link newLink=new Link(data);
        if(isEmpty()){
            head=newLink;
        }else{
            rear.next=newLink;
        }
        newLink.previous=rear;
        rear=newLink;
    }

    @Override
    public T deleteHead() {
        T oldheaddata=null;
        if(!isEmpty()){
             oldheaddata=head.data;
             head=head.next;
            if(head!=null){
                head.previous=null;
            }else{//说明删除的是最后一个节点，那么尾节点的堆也应被赋值为空
                rear=null;
            }
        }else{
            throw new NullPointerException("队列为空呢！");
        }
        return oldheaddata;
    }

    @Override
    public T deleteRear() {
        T oldreardata=null;
        if(!isEmpty()){
            oldreardata=rear.data;
            rear=rear.previous;
            if(rear!=null){
                rear.next=null;
            }else{
                head=null;
            }
        }else{
            throw new NullPointerException("队列为空呢！");
        }
        return oldreardata;
    }

    @Override
    public T find(T t) {
        T finddata=null;
        if(isEmpty()){
            throw new NullPointerException("队列为空呢！");
        }else{
            Link tmp=head;
            while(tmp!=null){
                if(tmp.data.equals(t)){
                    finddata=t;
                    break;
                }
                tmp=tmp.next;
            }
        }
        return finddata;
    }

    @Override
    public T delete(T t) {
        T olddata=null;
        if(isEmpty()){
            throw new NullPointerException("队列为空呢！");
        }else{
            Link tmp=head;
            while(tmp!=null){
                if(tmp.data.equals(t)){
                    break;
                }else{
                tmp=tmp.next;
                }
            }
            if(tmp==null){
                return null;
            }
            olddata=tmp.data;
            if(tmp==head){
                head=head.next;
                if(head!=null){
                    head.previous=null;
                }else{
                    rear=null;
                }
            }else if(tmp==rear){
                rear=rear.previous;
                if(rear!=null){
                    rear.next=null;
                }else{
                    head=null;
                }
            }
            else{
                tmp.previous.next=tmp.next;
                tmp.next.previous=tmp.previous;
            }
        }
        return olddata;
    }

    @Override
    public boolean insertAfter(T key, T data) {
        if(isEmpty()){
            throw new NullPointerException("队列为空呢！");

        }else{
            Link tmp=head;
            while(tmp!=null){
                if(tmp.data.equals(key)){
                    break;
                }else{
                    tmp=tmp.next;
                }
            }
            if(tmp==null){
                return false;
            }else{
                Link newLink=new Link(data);
                if(tmp==rear){
                    rear=newLink;
                }else{
                    newLink.next=tmp.next;
                    tmp.next.previous=newLink;
                }
                tmp.next=newLink;
                newLink.previous=tmp;
                return true;
            }

        }

    }

    @Override
    public int size() {
        int count = 0;
        Link current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void displayListSHead() {
        System.out.println("List (first-->last):");
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    @Override
    public void displayListSRear() {
        System.out.println("List (last-->first):");
        Link current = rear;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
    }
}
class TestMyDbqueue{
    public static void main(String[] args) {
     MyDbQueue<String> myDbQueue=new MyDbQueue<String>();
        myDbQueue.insertLast("BBB");
        myDbQueue.insertFirst("AAA");
        myDbQueue.insertLast("CCC");
        myDbQueue.insertLast("EEE");
        myDbQueue.displayListSHead();
        myDbQueue.insertAfter("CCC","DDD");
        myDbQueue.displayListSHead();
        myDbQueue.displayListSRear();
        System.out.println(myDbQueue.size());
        myDbQueue.insertFirst("A-E如下：");
        myDbQueue.displayListSHead();
        System.out.println("寻找CCC结果："+myDbQueue.find("CCC"));
        myDbQueue.deleteHead();
        myDbQueue.deleteRear();
        System.out.println("删掉队首和队尾后:");
        myDbQueue.displayListSHead();
        myDbQueue.delete("BBB");
        System.out.println("删去了BBB结果：");
        myDbQueue.displayListSHead();
        System.out.println("现在的队尾：");
        System.out.println(myDbQueue.peekRear());
    }
}