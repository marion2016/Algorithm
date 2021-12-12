package com.xf.practice.select100;

import java.util.Arrays;

public class L_0006 {

    public String convert(String s, int numRows) {
        String[] strs = new String[numRows];
        Arrays.fill(strs, "");
        boolean revert = false;
        int index = 0;
        int len = s.length();

        if (numRows == 1) {
            System.out.println(s);

            return s;
        }

        while (index < len) {
            if (revert) {
                for (int i = numRows - 1; i > 0 && index < len; i--) {
                    strs[i] += ""+s.charAt(index++);
                }
            } else {
                for (int i = 0; i < numRows - 1 && index < len; i++) {
                    strs[i] += ""+s.charAt(index++);
                }
            }
            revert = !revert;

        }

        String ans = "";

        for (int i = 0; i < numRows; i++) {
            ans += strs[i];
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        L_0006 ins = new L_0006();
        ins.convert("PAYPALISHIRING",2);
        ins.convert("P",2);
        ins.convert("PA",2);

    }
}
