package com.lyf.practice;

import java.util.Scanner;

/**
 * Created by fangjiejie on 2017/9/14.
 */
public class L1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(couqian(n));
    }
    public static int couqian(int n){
        int money[]={1,5,10,20,50,100};
        int l=money.length;
        int [][]dp=new int[l][n+1];
        int max=Integer.MAX_VALUE;
        for(int j=1;j<=n;j++){
            dp[0][j]=max;
            if(j>=money[0]&&dp[0][j-money[0]]!=max){
                dp[0][j]=dp[0][j-money[0]]+1;
            }
        }
        for(int i=1;i<l;i++)
        {
            for(int j=1;j<=n;j++){
                int left=max;
                if(j>=money[i]) {
                    dp[i][j] = dp[i][j - money[i]] + 1;
                }
                dp[i][j]=Math.min(dp[i-1][j],left);
            }
        }
        int sum=0;
            for (int j=1;j<=n;j++)
            {
             if(dp[5][j]!=max){
                 sum++;
             }
        }
        return sum;
    }
}
