package com.lyf.dp;

/**
 * Created by fangjiejie on 2017/4/15.
 */
public class SkipGame {
    public static void main(String[] args) {

    }
    public int jump(int a[]){
        int jump=0;//代表到达当前位置跳跃的最少步数
        if(a.length==0||a==null){
            return -1;
        }
        int cur=0;//代表当前位置
        int next=0;//代表下一次多跳一步能够到达的最远位置
        for(int i=0;i<a.length;i++){
            if(cur<i){//当前位置小于被遍及的位置，则需要再跳一步
                jump++;
                cur=next;//如果只能跳jump步，最远可以到达的位置
            }
            next=Math.max(next,i+a[i]);//下一次再多跳一步可以到达的最远位置
        }
        return jump;
    }
}
