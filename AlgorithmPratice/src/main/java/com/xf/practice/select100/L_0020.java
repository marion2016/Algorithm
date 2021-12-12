package com.xf.practice.select100;

import java.util.Stack;

public class L_0020 {



    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chs = s.toCharArray();

        for (char ch : chs) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            check(stack, ch, '}', '{');
            check(stack, ch, ')', '(');
            check(stack, ch, ']', '[');

        }

        return stack.isEmpty();
    }

    public boolean check(Stack<Character> stack,char ch, char target, char src) {
        if (ch == target && !stack.isEmpty() && stack.peek() == src) {
            stack.pop();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        L_0020 ins = new L_0020();

    }
}
