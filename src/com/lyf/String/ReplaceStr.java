package com.lyf.String;

import org.junit.Test;

/**
 * Created by fangjiejie on 2017/6/2.
 */
public class ReplaceStr {
    public String replace(String str,String from,String to){
        char []str1=str.toCharArray();
        char []str2=from.toCharArray();
        int match=0;
        for(int i=0;i<str1.length;i++){
            if(str1[i]==str2[match]){
                match++;
                if(match==str2.length){
                    clear(str1,i,str2.length);
                    match=0;
                }
            }else{
                if(str1[i]==str2[0]){
                    i--;
                }
                match=0;
            }
        }
        String tmp="";
        String res="";
        for(int i=0;i<str1.length;i++){
            if(str1[i]!=0){
                tmp=tmp+String.valueOf(str1[i]);
            }else if(str1[i]==0&&(i==0||str1[i-1]!=0)){
                res=res+tmp+to;
                tmp="";
            }
        }
        res+=tmp;
        return res;
    }

    private void clear(char[] str1, int i, int length) {
         while(length!=0){
             str1[i--]=0;
             length--;
         }
    }
@Test
    public void test(){
        String s1="123abcabc";
        String f1="abc";
        String t1="X";
        System.out.println(replace(s1,f1,t1).toString());

    }
}
