package com.lyf;

import java.util.LinkedList;

/**
 * Created by fangjiejie on 2017/4/10.
 */
public class L {
    public static void main(String[] args) {
       LinkedList d=new LinkedList();
        LinkedList v=d;
       d.addFirst("hhhhhh");
        System.out.println(d.get(0));
        System.out.println(v.get(0));
    }
}
