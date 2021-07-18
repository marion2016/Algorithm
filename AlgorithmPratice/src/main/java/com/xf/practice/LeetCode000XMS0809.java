package com.xf.practice;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode000XMS0809 {
    public static List<String> generateParenthesis(int n) {
        List<String> list= new ArrayList<>();
        if(n<=0){
            return list;
        }
        String l = "(";
        String r = ")";
        int m = n*2;

        if(m==2){
            list.add(l+r);
        } else {
            List<String> tmp = generateParenthesis(n-1);
            if(!tmp.isEmpty()){
                for(String str:tmp){
                    list.add(l+str+r);
                    list.add(str+l+r);
                    list.add(l+r+str);
                }
            }


            //if(n%2==0){
                tmp = generateParenthesis(n-2);
                if(!tmp.isEmpty()){
                    for(String str:tmp){
                        list.add(str+str);
                    }
                }
            //}

        }
        return list.stream().filter(str->str.length()==n*2).collect(Collectors.toList());
    }

    public static void main(String[] args){

        String[] tmp = new String[]{"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"};
        //String[] tmp = new String[]{"(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"};
        System.out.println(generateParenthesis(5));
        System.out.println(generateParenthesis(5).size());
        System.out.println(tmp.length);
    }

}
