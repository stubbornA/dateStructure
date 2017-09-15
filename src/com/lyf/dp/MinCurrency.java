package com.lyf.dp;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/5/18.
 */
public class MinCurrency {
    public int getMinNumber1(int arr[],int aim){
        if(arr==null||arr.length==0||aim<0){
            return -1;
        }
        int n=arr.length;
        int dp[][]=new int[n][aim+1];
        int max=Integer.MAX_VALUE;
        //dp[0..N-1][0]默认值为0，表示找的钱数为0时需要的钱币最少张数，因为不需要任何钱币。默认为0就好了
        for(int j=1;j<=aim;j++){//求只能使用arr[0]货币的情况下，找1...aim所用的最少张数
            dp[0][j]=max;
            if(j>=arr[0]&&dp[0][j-arr[0]]!=max){
                dp[0][j]=dp[0][j-arr[0]]+1;
            }
        }
        for(int i=1;i<n;i++){
            //剩下的位置，从左到右，从上到下计算dp[i][j],dp[i][j]表示找的钱数为j时，
            // 所用的钱币类别从arr[0]到arr[i]为止，所用的最小钱币数量
            for(int j=1;j<=aim;j++){
                int left=max;
                if(j>=arr[i]&&dp[i][j-arr[i]]!=max){
                    left=dp[i][j-arr[i]]+1;//如果j-arr[i]这些钱所用钱币数可数，那么j这些钱只需要再加上一张arr[i]钱币就可以了
                }
                dp[i][j]=Math.min(dp[i-1][j],left);//跟不用arr[i]这种钱币所用的最少钱币数作比较，取一个最少值
            }
        }
        return dp[n-1][aim]==max?-1:dp[n-1][aim];
    }
    @Test
    public void test1(){
        int a[]={5,2,3};
        int aim=20;
        System.out.println(getMinNumber1(a,aim));
    }
    public int getMinNumber2(int arr[],int aim){
        if(arr==null||arr.length==0||aim<0){
            return -1;
        }
        int n=arr.length;
        int max=Integer.MAX_VALUE;
        int [][]dp=new int[n][aim+1];
        for(int j=1;j<=aim;j++){
            dp[0][j]=max;
        }
        if(arr[0]<=aim){
            dp[0][arr[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=aim;j++){
                int left=max;
                if(j>=arr[i]&&dp[i-1][j-arr[i]]!=max){
                    left=dp[i-1][j-arr[i]]+1;
                }
                dp[i][j]=Math.min(dp[i-1][j],left);
            }
       }
        return dp[n-1][aim]==max?-1:dp[n-1][aim];
    }
    @Test
    public void test2(){
        int a1[]={5,2,3};
        int aim1=20;
        int a2[]={5,2,3,5};
        int aim2=10;
        int aim3=15;
        System.out.println(getMinNumber2(a1,aim1));
        System.out.println(getMinNumber2(a2,aim2));
        System.out.println(getMinNumber2(a2,aim3));
    }
}
