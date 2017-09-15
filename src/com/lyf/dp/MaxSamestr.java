package com.lyf.dp;

import java.util.Scanner;

/**
 * Created by fangjiejie on 2017/9/14.
 */
public class MaxSamestr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        char []str1=s1.toCharArray();
        char []str2=s2.toCharArray();
        int [][]dp=new int[s1.length()][s2.length()];
        int max=0;
        int index=-1;
        for(int i=0;i<str1.length;i++){
            if(str1[i]==str2[0]){
                dp[i][0]=1;
                max=1;
                index=0;
            }
        }
        for(int j=0;j<str2.length;j++){
            if(str2[j]==str1[0]){
                dp[0][j]=1;
                max=1;
            }
        }
        for(int i=1;i<str1.length;i++){
            for(int j=1;j<str2.length;j++){
                if(str1[i]==str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                    index=i;
                }
            }
        }

        System.out.println("最大公共子串长度为："+max);
        if(index>=0) {
            String resultS = s1.substring(index-max, index);
            System.out.println("最大公共子串为："+resultS);
        }
    }
}
