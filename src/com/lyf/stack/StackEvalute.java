package com.lyf.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fangjiejie on 2017/4/10.
 */
public class StackEvalute {
    private static Stack<Double> stackData=new Stack<>();
    private static Stack<Character> stackCharacter=new Stack<>();
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         String str=sc.nextLine();
        System.out.println(evalDouble(str.toCharArray()));
    }
    public static Double evalDouble(char []s){
        for(int i=0;i<s.length;i++){
            if(s[i]=='+'||s[i]=='-'||s[i]=='*'||s[i]=='/'){
                stackCharacter.push(s[i]);
            }else if(s[i]=='('){

            }else if(s[i]==')'){
                   double val=stackData.pop();
                   char tmpchar=stackCharacter.pop();
                   if(tmpchar=='+') val=val+stackData.pop();
                   else if(tmpchar=='-') val=stackData.pop()-val;
                   else if(tmpchar=='*') val=val*stackData.pop();
                   else if(tmpchar=='/') val=stackData.pop()/val;
                stackData.push(val);
            }else {
                Double tmpdata=Double.parseDouble(Character.toString(s[i]));
                stackData.push(tmpdata);
            }
        }
        return stackData.pop();
    }
}
