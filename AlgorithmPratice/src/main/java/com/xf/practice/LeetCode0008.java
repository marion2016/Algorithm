package com.xf.practice;

public class LeetCode0008 {
    public static int myAtoi(String s) {
        int minus=0,start=0,len;

        s=s.trim();
        len = s.length();
        if(len<1){
            return 0;
        }

        if(s.charAt(0)=='-'){
            minus =-1;
            start =1;
        } else if (s.charAt(0)=='+'){
            minus =1;
            start =1;
        } else {
            minus = 1;
            start = 0;
        }


        StringBuffer sb = new StringBuffer();

        for(;start<len;start++){
            String ch = String.valueOf(s.charAt(start));
            if(ch.matches("[0-9]")){
                sb.append(ch);
            } else {
                break;
            }
        }

        if(sb.length() == 0 ){
            return 0;
        } else {
            try{
                return Integer.valueOf(sb.toString())*minus;
            } catch (NumberFormatException ne){
                return minus>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(myAtoi("4193 with words"));;
        System.out.println(myAtoi("words and 987"));;
        System.out.println(myAtoi("-91283472332"));;
        System.out.println(myAtoi("91283472332"));;
        System.out.println(myAtoi(""));;
        System.out.println(myAtoi(" 42"));;
        System.out.println(myAtoi(" -42"));;
        System.out.println(myAtoi(" +1"));;

    }
}
