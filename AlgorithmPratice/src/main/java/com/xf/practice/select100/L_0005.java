package com.xf.practice.select100;

public class L_0005 {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = Integer.MIN_VALUE;
        String ans = s.substring(0, 1);

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = i + L;

                if (j >= n) {
                    continue;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] || dp[i][j];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, i + max);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        L_0005 ins = new L_0005();

    }
}
