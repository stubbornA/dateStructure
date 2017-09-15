package com.lyf.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by fangjiejie on 2017/5/12.
 */
public class MaxTree {
    Node head=null;
    public Node buildMaxTree(int arr[]){
        Node []nodes=new Node[arr.length];
        for(int i=0;i<arr.length;i++){//把数组中的每个元素建立成一个节点
            nodes[i]=new Node(arr[i]);
        }
        Stack<Node> stack=new Stack<>();
        Map<Node,Node> leftfathermap=new HashMap<>();//来保存每个节点找到的“左父亲”
        Map<Node,Node> rightfathermap=new HashMap<>();//来保存每个节点找到的“左父亲”

        // 一旦当前遍及的节点比栈顶元素小，就依次弹出，直到栈顶元素具备当他父亲的条件（父元素比子元素大），再把当前元素进栈
        //当前栈具备这样的特点： 每个元素的前一个元素都具备是此元素的父亲的条件
        for(int i=0;i<nodes.length;i++){//构造从栈底到栈顶递减的序列，为的是 给当前遍及的节点找到第一个比它大的“左父亲”，
            while(!stack.empty()&&stack.peek().value<nodes[i].value){
                popAndSet(stack,leftfathermap);
            }
            stack.push(nodes[i]);
        }
        while(!stack.empty()){
            popAndSet(stack,leftfathermap);
        }

        for(int i=nodes.length-1;i>=0;i--){//构造从栈底到栈顶递减的序列，为的是 给当前遍及的节点找到第一个比它大的“右父亲”，
            while(!stack.empty()&&stack.peek().value<nodes[i].value){
                popAndSet(stack,rightfathermap);
            }
            stack.push(nodes[i]);
        }
        while(!stack.empty()){
            popAndSet(stack,rightfathermap);
        }

        for(int i=0;i<nodes.length;i++){
            Node leftfater=leftfathermap.get(nodes[i]);
            Node rightfather=rightfathermap.get(nodes[i]);
            if(leftfater==null&&rightfather==null) {//如果左右父亲都为空，整个序列没有找到比它大的元素，那他就是最大的，为MaxTree的根元素
                head = nodes[i];
            }else if(rightfather==null){//右父亲不存在，那么左父亲就是它的父亲
                if(leftfater.left==null){//把它放到父亲的左右孩子节点中
                    leftfater.left=nodes[i];
                }else{
                    leftfater.right=nodes[i];
                }
            }else if(leftfater==null){//左父亲不存在，那么右父亲就是它的父亲
                if (rightfather!=null){//把它放到父亲的左右孩子节点中
                    rightfather.left=nodes[i];
                }else{
                    rightfather.right=nodes[i];
                }
            }else{//左右父亲都存在，那么比较左右父亲，取数值较小的那个做父亲
                Node father=leftfater.value<rightfather.value?leftfater:rightfather;
                if(father.left==null){//把它放到父亲的左右孩子节点中
                    father.left=nodes[i];
                }else{
                    father.right=nodes[i];
                }
            }
        }
        return head;//返回根结点
    }
    public void popAndSet(Stack<Node> stack, Map<Node,Node> map){//此函数用来弹出栈顶元素，并且记录弹出元素的临时父亲
        Node tmpNode=null;
        tmpNode=stack.pop();
        if(!stack.empty()){
            map.put(tmpNode,stack.peek());
        }
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}
