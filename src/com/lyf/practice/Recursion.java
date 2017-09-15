package com.lyf.practice;

import java.util.Scanner;

/**
 * Created by fangjiejie on 2017/9/14.
 */
public class Recursion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(walk(n));
    }
    public static int walk(int n){
        if(n<1) return 0;
        if(n==1) return 1;
        else return walk(n-1)+walk(n-2)+walk(n-3)+walk(n-4)+walk(n-5)+1;
    }
}
