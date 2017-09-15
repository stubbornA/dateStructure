package com.lyf.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangjiejie on 2017/4/26.
 */
public class ITreeChild<T> {
   public static class Node<T>{//节点
         T data;//节点元素值
         SonNode first;//记录第一个子节点，根据第一个子节点，可以找到所有的子节点
        public Node(T data) {
            this.data = data;
            this.first=null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    private static class SonNode{//子节点链
         int pos;//当前子节点的位置
         SonNode next;//下一个子节点，从而得到下一个子节点的位置

        public SonNode(int pos, SonNode next) {
            this.pos = pos;
            this.next = next;
        }
    }
    private int treeSize=100;
    private Node<T> []nodes;
    private int nodeNums;
    public ITreeChild(T data){
        nodes=new Node[treeSize];
        nodes[0]=new Node<T>(data);
        nodeNums++;
    }
    public void addNode(T data , Node<T> parent){
          for(int i=0;i<treeSize;i++){
              if(nodes[i]==null){
                  nodes[i]=new Node<T>(data);//创建新节点
                  if(parent.first==null){
                      parent.first=new SonNode(i,null);//如果该父节点没有子节点，则创建第一个子节点，添加到first位置
                  }else{
                      SonNode tmp=parent.first;
                      while(tmp.next!=null){
                          tmp=tmp.next;
                      }
                      tmp.next=new SonNode(i,null);//找到最后一个字节点，添加到最后一个子节点的next位置
                  }
                  nodeNums++;
                  return;
              }
          }
        throw new ArrayIndexOutOfBoundsException("满了");
    }
    public Node root(){
          return nodes[0];
    }
    public List<Node<T>> getChildren(Node<T> parent){
          List<Node<T>> list=new ArrayList<>();
          SonNode tmp=parent.first;
         while(tmp!=null){
               list.add(nodes[tmp.pos]);
               tmp=tmp.next;
                 }
        return list;
    }
    public int deep(){
        return deep(root());
    }
    private int deep(Node<T> node){
        if(node.first==null){
            return 1;
        }else{
            int dep=0;
            SonNode tmp=node.first;
            while(tmp!=null){
               int dt=deep(nodes[tmp.pos]);
               dep=Math.max(dt,dep);
                tmp=tmp.next;
            }
            return dep+1;
        }
    }
    public int pos(Node<?> node){
        for (int i = 0 ; i < treeSize ; i++){
            //找到指定节点
            if (nodes[i] == node){
                return i;
            }
        }
        return -1;
    }
    public String NodeToString(Node<T> node){
        StringBuffer sb=new StringBuffer(node.toString()+"节点的子节点有：");
        List<Node<T>> list=getChildren(node);
        for(Node<T> l:list){
            sb.append(l.toString()+",");

        }
        return sb.toString();
    }

}
class TestITreeChild{
    public static void main(String[] args) {
        ITreeChild<String> treeChild=new ITreeChild<String>("aaa");
        ITreeChild.Node root=treeChild.root();
        System.out.println(treeChild.deep());
        treeChild.addNode("bbb",root);
        treeChild.addNode("ccc",root);
        treeChild.addNode("ddd",root);
        List<ITreeChild.Node<String>> list=treeChild.getChildren(treeChild.root());
        ITreeChild.Node nodeB= list.get(0);
        treeChild.addNode("eee",nodeB);
        treeChild.addNode("fff",nodeB);
        treeChild.addNode("ggg",nodeB);
        System.out.println(treeChild.NodeToString(treeChild.root()));
        System.out.println(treeChild.NodeToString(nodeB));
        System.out.println(treeChild.deep());
        System.out.println(treeChild.pos(nodeB));
        List<ITreeChild.Node<String>> list1=treeChild.getChildren(nodeB);
        ITreeChild.Node nodeF=list1.get(1);
        treeChild.addNode("hhh",nodeF);
        System.out.println(treeChild.deep());
    }
}
