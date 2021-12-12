package com.xf.practice.old;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode1576 {

    public static String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                //前面一个字符  如果当前是第0个的话 字符就为‘ ’
                char ahead = i == 0 ? ' ' : chars[i - 1];
                //后面一个字符  如果当前是最后一个的话 字符就为‘ ’
                char behind  = i == chars.length - 1 ? ' ' : chars[i + 1];
                //从a开始比较  如果等于前面或者后面的话 就+1
                char temp = 'a';
                while (temp == ahead || temp == behind ) {
                    temp++;
                }
                //找到目标字符后 做替换
                chars[i] = temp;
            }
        }
        return new String(chars);
    }



    public static void main(String[] args){

        char i='z';
        String chars="abcdefghijklmnopqrstuvwxyz";
        String input="??yw?ipkj?";
        modifyString(input);
        LinkedHashMap<Integer,Object> rec = new LinkedHashMap<>();

        HashMap<String,String> lr= new HashMap<>();
        AtomicInteger at = new AtomicInteger(0);
        input.chars().mapToObj(c->(char)c).forEach(c-> {
                    int index = at.getAndIncrement();
                    if (c.equals('?')) {
                        char left = index == 0 ? ' ' : input.charAt(index - 1);
                        char right = index==input.length()-1?' ':input.charAt(index + 1);
                        char temp = 'a';
                        while(temp == left || temp ==right){
                            temp++;
                        }
                        System.out.println(temp);
                    }

                }
        );



    }

}
