package com.lyf.String;

/**
 * Created by fangjiejie on 2017/5/13.
 */
public class NumberSum {
    public static int getSum(String str){
        if(str==null){
            return 0;
        }
        int sum=0;
        boolean sign=true;//判断正负号
        int num=0;//一个完整的数字
        char []s=str.toCharArray();
        int cur;
        for(int i=0;i<s.length;i++){
           cur=s[i]-'0';
           if(cur<0||cur>9){
               sum+=num;
               num=0;
               if(s[i]=='-'){
                   if(i-1>=0&&s[i-1]=='-'){
                       sign=!sign;
                   }else{
                       sign=false;
                   }
               }else {
                   sign=true;
               }
           }else {
               num = num * 10 + cur * (sign ? 1 : -1);
           }
        }
        sum+=num;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum("A1CD2E33"));
        System.out.println(getSum("A-1B--2C-D6E"));
    }
}
