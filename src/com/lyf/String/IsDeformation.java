package com.lyf.String;

/**
 * Created by fangjiejie on 2017/5/13.
 */
public class IsDeformation {
    public static void main(String[] args) {
//        System.out.println(judge("absd","asbd"));
//        System.out.println(judge("adsd","asbd"));
        char a='5';
        System.out.println(a);
    }
    public static boolean judge(String str1,String str2){
        if(str1==null||str2==null||str1.length()!=str2.length())
        {
            return false;
        }
        char []arr1=str1.toCharArray();
        char []arr2=str2.toCharArray();
        int []record=new int[256];
        for(int i=0;i<arr1.length;i++){
            record[arr1[i]]++;//将字符类型做数组下标，可使其自动提升为int类型
        }
        for(int i=0;i<arr2.length;i++){
            if(record[arr2[i]]--==0){
                return false;
            }
        }
        return true;
    }
}
