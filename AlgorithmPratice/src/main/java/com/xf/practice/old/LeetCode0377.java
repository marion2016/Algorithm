package com.xf.practice.old;

import java.util.Arrays;

public class LeetCode0377 {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];   // dp的数组，需要按照dp规划的数据大小来，由于dp需要规划一个初始的数值，所以需要+1


        dp[0]=1;  //初始的时候，值是1

        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    dp[i]+=dp[i-num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(combinationSum4(nums,4));
    }
}
