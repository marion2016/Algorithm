package com.xf.practice.old;

import java.util.Arrays;

public class LeetCode1833 {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int i=0;i<costs.length;i++){
            if(coins>=costs[i]){
                coins -= costs[i];
                count+=1;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] costs={1,3,2,4,1};
        System.out.println(maxIceCream(costs,7));
    }
}
