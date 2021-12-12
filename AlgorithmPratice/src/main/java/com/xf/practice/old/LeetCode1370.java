package com.xf.practice.old;

import java.util.HashMap;
import java.util.Vector;

public class LeetCode1370 {

    public String sortString(String s) {
        Vector<Integer> vec = new Vector<>(26);

        HashMap<String,Character> map = new HashMap<>();
        map.put("min",'a');
        map.put("max",'z');
        char[] charr=s.toCharArray();
        for (char ch:charr){

        }
        s.chars().mapToObj(c->(char)c).forEach(c->{
            char min = map.get("min");
            if(c<min){
                map.put("min",c);
            }

        });
        return "";
    }

    public static void main(String[] args){
        char a1='a';
        char a2='b';
        char x;
        int a=0;
        Vector<Integer> vec = new Vector<>(26,0);
       // Vector<Integer> a(5,1);

        System.out.println("sss");
        //new LeetCode1370().sortString("ssss");
    }
}
