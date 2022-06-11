package com.mabo.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mabo
 * @Description   利用栈实现
 * 计算器
 * 简单加减乘除的功能
 */

public class Calculator {
    private ArrayStack numberStack=new ArrayStack();
    private ArrayStack operatorStack=new ArrayStack();
    private String string="122+432*1-22/22";

    public List getStringList(String  string) {
        char[] chars = string.toCharArray();
        List<String> list= new ArrayList<>();
        String s=null;
        for (int i = 0; i < chars.length; i++){
            char c=chars[i];
            if (c!='+'&&c!='-'&&c!='*'&&c!='/'){
                int a=c-'0';
                if (s==null){
                    s=String.valueOf(a);
                }
                else {
                    s=s+a;
                }
                if (s!=null&&(i==chars.length-1)){
                    list.add(s);
                }
            }
            else {
                if (s!=null){
                    list.add(s);
                    s=null;
                }
                list.add(String.valueOf(c));
            }
        }
        return list;
    }

    public void putString() throws Exception {
        List<String> stringList = getStringList(string);

        for (String  s : stringList) {
            operatorAndPop(s);
        }
    }
    /**
     * @Author mabo
     * @Description   获取当前字符的运算符
     * 0为数组
     * 1为+ -
     * 2为* /
     */

    public void operatorAndPop(String string) throws Exception {
        char c;
        if (string.equals("+")){
            c='+';
        }
        else if (string.equals("-")){
            c='-';
        }
        else if (string.equals("*")){
            c='*';
        }
        else if (string.equals("/")){
            c='/';
        }
        else {
            c='0';
        }
        if (string.equals("+")||string.equals("-")){  //+43    -45    /47    *42
           if (operatorStack.empty()){
               operatorStack.push(c);
           }
           else {
               int pop = operatorStack.pop();
               int num2 = numberStack.pop();
               int num1 = numberStack.pop();
               int result ;
               if (pop=='*'){
                   result=num1*num2;
               }
               else {
                   result=num1/num2;
               }
               numberStack.push(result);
               operatorStack.push(c);
           }
        }
        else if (string.equals("*")||string.equals("/")){
            operatorStack.push(c);
        }
        else {
            numberStack.push(Integer.valueOf(string));
        }

    }

    public int getResult() throws Exception {
        while (numberStack.getSize()>1){
            int num2 = numberStack.pop();
            int num1 = numberStack.pop();
            int operator = operatorStack.pop();
            int result;
            if (operator=='+'){
                result=num1+num2;
            }
            else if (operator=='-'){
                result=num1-num2;
            }
            else if (operator=='*'){
                result=num1*num2;
            }
            else{
                result=num1/num2;
            }
            numberStack.push(result);
        }
        return numberStack.pop();
    }



    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        calculator.putString();
        calculator.numberStack.show();
        calculator.operatorStack.show();
        int result = calculator.getResult();
        System.out.println("最终运算结果为"+result);

    }
}
