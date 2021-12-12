package com.xf.practice.old;

public class LeetCode0028 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0028().strStr("aaaaa","bba"));
        System.out.println(new LeetCode0028().strStr("hello","ll"));
        System.out.println(new LeetCode0028().strStr("",""));

    }
}
