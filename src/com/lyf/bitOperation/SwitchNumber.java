package com.lyf.bitOperation;

/**
 * Created by fangjiejie on 2017/5/13.
 */
public class SwitchNumber {
    public static void main(String[] args) {
        //第一种：位运算
        int a,b;
        a=10;
        b=20;
        System.out.println("交换前:"+"a="+a+",b="+b);
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("交换后:"+"a="+a+",b="+b);
        //第二种：算术运算
        int p,q;
        p=10;
        q=20;
        System.out.println("交换前:"+"p="+p+",q="+q);
        p=p+q;
        q=p-q;
        p=p-q;
        System.out.println("交换后:"+"p="+p+",q="+q);
    }
}
