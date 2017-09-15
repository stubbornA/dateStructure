package com.lyf.dp;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/5/17.
 */
public class MatrixMinPath {//dp[i][j]代表从起点到达当前位置为止的最短路径和
    public int getPathLen(int [][]matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int [][]dp=new int[row][col];
        dp[0][0]=matrix[0][0];
        for(int i=1;i<row;i++){//找到第一列的dp值
            dp[i][0]=dp[i-1][0]+matrix[i][0];
        }
        for(int j=1;j<col;j++){//找到第一行的dp值
            dp[0][j]=dp[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];//当前dp值为 从左边、上边去一个最小值，加上本身
            }
        }
        System.out.println("dp矩阵：");
        for(int[] i:dp){
            for(int j:i){
                System.out.print(j+",");
            }
            System.out.println();
        }
        return dp[row-1][col-1];
    }
    @Test
    public void test(){
        int arr[][]={
                {1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}
        };

        System.out.println("最短路径"+getPathLen(arr));
    }
}
