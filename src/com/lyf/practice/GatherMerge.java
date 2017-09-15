package com.lyf.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fangjiejie on 2017/9/12.
 */
public class GatherMerge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=5;
        while(t--!=0){
            int l1,l2;
            l1=sc.nextInt();
            l2=sc.nextInt();
            int a1[]=new int[l1];
            int a2[]=new int[l2];
            for(int i=0;i<l1;i++){
                a1[i]=sc.nextInt();
            }
            for(int j=0;j<l2;j++){
                a2[j]=sc.nextInt();
            }
            Arrays.sort(a1);
            Arrays.sort(a2);
            for(int i=0;i<l1;i++){
                System.out.print(a1[i]);
            }
            System.out.println();
            for(int j=0;j<l2;j++){
                System.out.print(a2[j]);
            }
            System.out.println();

            //去重函数
            int a1pos=0,a2pos=0;
            int []c=new int[l1+l2];
            int k=0;
            while(a1pos<a1.length&&a2pos<a2.length){
                if(a1[a1pos]<a2[a2pos]){
                    c[k++]=a1[a1pos];
                    a1pos++;
                }else if(a1[a1pos]>a2[a2pos]){
                    c[k++]=a2[a2pos];
                    a2pos++;
                }else if(a1[a1pos]==a2[a2pos]){
                    c[k++]=a2[a2pos];
                    a1pos++;
                    a2pos++;
                }
            }
            while(a1pos<l1){
                c[k++]=a1[a1pos++];
            }
            while (a2pos<l2){
                c[k++]=a2[a2pos++];
            }
            for(int i=0;i<k;i++){
                System.out.print(c[i]);
            }
            System.out.println();
//          System.out.println(t);
        }
    }
}
