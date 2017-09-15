package com.lyf.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangjiejie on 2017/4/22.
 */
public interface ITreeParent<T> {
    int pos(Node node);//返回包含指定值的节点的索引。
    void addNode(T elem,Node parent);
    Node root();
    int deep();
    List<Node<T>> getChildren(Node parent);
}
class Node<T>{
        T elem;
        int parent;

    public Node(T elem, int parent) {
        this.elem = elem;
        this.parent = parent;
    }
    public String toString(){
        return "父节点表示法[data=" + elem + ", parent="+ parent + "]";
    }
}
class TreeParent<T> implements ITreeParent<T> {
    private Node<T>[] nodes = null;
    private int treeSize=100;
    private int nodeNums;

    public TreeParent(T elem) {
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(elem, -1);
        nodeNums++;
    }

    @Override
    public int pos(Node node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addNode(T elem, Node parent) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node<>(elem, pos(parent));
                return;
            }
        }
        throw new RuntimeException("tree is full");
    }

    @Override
    public Node root() {
        return nodes[0];
    }

    @Override
    public int deep() {
        int deep = 0;
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null) {
                int tmp = 1;
                int parentId = nodes[i].parent;
                while (parentId != -1 && nodes[parentId] != null) {
                    tmp++;
                    parentId = nodes[parentId].parent;
                }
                deep = Math.max(deep, tmp);
            }
        }
        return deep;
    }

    @Override
    public List<Node<T>> getChildren(Node parent) {
        List<Node<T>> list = new ArrayList<>();
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null && nodes[i].parent == pos(parent)) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeParent<String> treeParent=new TreeParent<>("root");
        System.out.println(treeParent.root().elem);
        treeParent.addNode("elem1",treeParent.root());
        treeParent.addNode("elem2",treeParent.root());
        treeParent.addNode("elem3",treeParent.root());
        List<Node<String>> list=treeParent.getChildren(treeParent.root());
        for(Node<String> node:list){
            System.out.println(node.toString());
        }
        treeParent.addNode("elem4",list.get(0));
        treeParent.addNode("elem5",list.get(0));
        treeParent.addNode("elem6",list.get(0));
        List<Node<String>> list1=treeParent.getChildren(list.get(0));
        for(Node<String> node:list1){
            System.out.println(node.toString());
        }
        treeParent.addNode("elem7",list1.get(0));
        System.out.println(treeParent.deep());
        }
}

