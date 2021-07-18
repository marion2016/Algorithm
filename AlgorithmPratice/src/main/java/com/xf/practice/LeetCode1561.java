package com.xf.practice;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode1561 {
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = piles.length/3;
        int sum = 0;
        for(int i=1;i<count+1;i++){
            sum += piles[piles.length-2*i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] piles ={2,4,1,2,7,8};
        System.out.println(maxCoins(piles));

        int[] piles1={9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(piles1));

        int[] piles2={2,4,5};
        System.out.println(maxCoins(piles2));

    }
}
