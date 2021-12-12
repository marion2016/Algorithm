package com.xf.practice.select100;

import java.util.HashMap;

public class L_0003 {

    /*
    需要遍历字符串，所以第一时间想到的是滑动窗口
    右：
    左： 当右边的字符已经出现在窗口内，则左划到相同字符的index处。

    需要用的数据结构
    HashMap, 保存每个字符的index。
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        HashMap<Character, Integer> windows = new HashMap<>();

        while (right < n) {
            char rightch = s.charAt(right);

            while (windows.containsKey(rightch)) {
                char leftch = s.charAt(left);
                windows.remove(leftch);
                left++;
            }
            windows.put(rightch, right);
            ans = Math.max(ans, right - left + 1);
            right++;

        }

        return ans == Integer.MIN_VALUE? 0: ans;
    }

    public static void main(String[] args) {
        L_0003 ins = new L_0003();
        ins.lengthOfLongestSubstring("abcabcbb");
    }
}
