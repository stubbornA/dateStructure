package com.lyf.stack;

import java.util.LinkedList;

/**
 * Created by fangjiejie on 2017/5/10.
 */
public class WindowMaxValue {
    public static void main(String[] args) {
        int a[]={4,3,5,4,3,3,6,7};
        int b[]=getResult(a,3);
        for(int i:b){
            System.out.print(i+",");
        }
    }
    public static int[] getResult(int []arr,int s){//值得说明的是，我们进出队列的是数组下标，以此作为标记
        if(arr==null&&arr.length<s&&s<1){//把异常情况排除
            return  null;
        }
        int []result=new int[arr.length-s+1];
        LinkedList<Integer> list=new LinkedList<>();
        int index=0;
        for(int i=0;i<arr.length;i++){
            while(!list.isEmpty()&&arr[list.peekFirst()]<=arr[i]){//如果新要添加的值比末尾保留值大，末尾保留值则无用剔除，
                list.pollLast();
            }
            list.add(i);//整个队列始终保持着以队首最大的降序序列
            if(list.peekFirst()==i-s){//如果队首值过期，也就是队首已经不再窗口范围内，就把它剔除
                list.pollFirst();
            }
            if(i>=s-1){
                result[index++]=arr[list.peekFirst()];//队首为最大值
            }
        }
        return result;
    }
}
