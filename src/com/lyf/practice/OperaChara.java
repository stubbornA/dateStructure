package com.lyf.practice;

/**
 * Created by fangjiejie on 2017/5/12.
 */
public class OperaChara {
    public static void main(String[] args) {
        int i=5,j=5,p,q;
        p=(i++)+(i++)+(i++);
        //p=5+6+7=18 i=8
        q=(++j)+(++j)+(++j);
        //q=6+7+8=21 j=8
        System.out.println(i+","+j+","+p+","+q);
    }
}
