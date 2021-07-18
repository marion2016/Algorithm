package com.xf.practice;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode0136 {

    public static int singleNumber(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int res = nums[0];

        for(int i = 1;i<nums.length;i++){
            res ^= nums[i];
        }

        return res;
    }


    //以下是个傻逼算法
    public static int singleNumber_HashMap(int[] nums) {
        int r = 0;
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int num:nums){
            if(res.keySet().contains(num)){
                res.put(num,res.get(num)+1);
            } else {
                res.put(num,1);
            }
        }

        for(int key:res.keySet()){
            if(res.get(key) == 1){
                r = key;
                break;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        int[] ns = {4,4,1,2,1,2,3,5,3,4,4,6,7,8,6,7,8,9,10,10,9};
        System.out.println(singleNumber(ns));
    }
}
