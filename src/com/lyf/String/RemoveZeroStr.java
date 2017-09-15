package com.lyf.String;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/5/19.
 */
public class RemoveZeroStr {
    public String doRemove(String str,int k){
        if(str==null||k<=0){
            return str;
        }
        char s[]=str.toCharArray();
        int start=-1;
        int count=0;
        for(int i=0;i<s.length;i++) {
            if (s[i] == '0') {
                start = start==-1?i:start;
                count++;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        //count--;
                        s[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
            if(count==k){
                while(count!=0){
                    count--;
                    s[start++]=0;
                }
            }
        return String.valueOf(s);
    }
    @Test
    public void test1(){


        int count=5;
        while(count--!=0){
            System.out.print(count);
        }
        System.out.println();
        int s=5;
        while(s!=0){
            s--;
            System.out.print(s);
        }
        System.out.println();
        char k=0;
        System.out.println(k);

    }
    @Test
    public void test2(){
        String s1="A00B";
        System.out.println(doRemove(s1,2));
        String s2="A00000B000";
        System.out.println(doRemove(s2,3));
    }
    /*
    * char a=0和char a=‘0’有什么区别？表现在内存中，二者有什么区别？
    *在ASCII编码中，字符'0'的编码为48，char a = ‘0’中a的值在内存中的二进制表示为48，而char a=0的a就是内存表示就为0。
    * */
}
