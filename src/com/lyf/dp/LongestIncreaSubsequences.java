package com.lyf.dp;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/5/16.
 */
public class LongestIncreaSubsequences {
    public static int[] getdp(int arr[]){
        int dp[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){//从左向右 找以当前元素为最大值而结尾时的序列中，最长递增子序列的长度
            dp[i]=1;
            for(int j=i-1;j>=0;j--){//找倒数第二个数，谁的递增子序列最大，选谁
                if(arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
    public static int[] getSubsequence(int arr[]){
        int dp[]=getdp(arr);
        System.out.print("dp数组元素：");
        for(int i:dp){
            System.out.print(i+",");
        }
        System.out.println();
        int lenth=0;
        int index=0;
        //int mval
        for(int i=0;i<dp.length;i++){
          if(dp[i]>lenth){
              lenth=dp[i];//寻找最长递增子序列的长度
              index=i;//找递增序列最大长度所在的元素索引
          }
        }
        int []result=new int[lenth];//创建结果数组
        result[--lenth]=arr[index];
        for(int j=index-1;j>=0;j--){
            if(dp[j]==dp[index]-1&&arr[j]<arr[index]){//如果当前元素dp值=后一个元素dp-1，而且元素值比后一个元素值小，则被找到
               //System.out.println("index:"+index);
                result[--lenth]=arr[j];
                index=j;//记录新找到的元素的索引，在下次寻找中作比较，此行为并不影响j值的迭代，
            }
        }

        return result;
    }
    @Test
    public void test(){
        int arr[]={5,2,3,7,8,4,6,9};
        System.out.print("原数组：");
        for(int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
        int res[]=getSubsequence(arr);
        System.out.print("最长递增子序列：");
        for(int i:res){
            System.out.print(i+",");
        }
    }
}
