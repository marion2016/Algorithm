package com.xf.practice;

public class LeetCode1486 {
    public static int xorOperation(int n, int start) {
            int res=start;
            for(int i=1;i<n;i++){
                res = res ^ (start + 2*i);
            }
            return res;
    }

    public static void main(String[] args) {
       // xorOperation(5,0);
        xorOperation(4,3);
        xorOperation(1,7);
        xorOperation(10,5);

    }
}
