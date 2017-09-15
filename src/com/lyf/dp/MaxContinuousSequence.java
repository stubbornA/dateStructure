package com.lyf.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangjiejie on 2017/5/13.
 */
public class MaxContinuousSequence {
    public static int getSequence(int arr[]){
        int max=0;//max总是取遍历到当前位置时最大的序列长度
        Map<Integer,Integer> map=new HashMap<>();//建立一个map，key为数值，value为该数值所在连续数列的长度
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){//map中不保存重复的数值
                map.put(arr[i],1);//将，遍历到的数值放入map中，此时自创序列，长度为1
                if(map.containsKey(arr[i]-1)){//如果存在左边相邻的数字，把这两个序列进行合并
                    max=Math.max(max,merge(map,arr[i]-1,arr[i]));
                }
                if(map.containsKey(arr[i]+1)){//如果存在右边相邻的数字，把这两个序列进行合并
                    max=Math.max(max,merge(map,arr[i],arr[i]+1));
                }
            }
        }
        return max;
    }

    private static int merge(Map<Integer, Integer> map, int less, int more) {
        int length=0;
        int left=less-map.get(less)+1;//根据将要合并的less序列，找到这个序列里面最小的数值
        int right=more+map.get(more)-1;//根据将要合并的more序列，找到这个序列里面最大的数值
        length=right-left+1;//序列合并后的长度
        map.put(left,length);//我们只需记录这个序列中的最小值的length
        map.put(right,length);//和这个序列中的最大值的length
        return length;
    }

    public static void main(String[] args) {
        int a[]={4,8,5,7,1,3,2};
        System.out.println(getSequence(a));
    }
}
