package com.xf.practice;

import java.util.HashMap;

public class LeetCode1818 {
    public int minAbsoluteSumDiff(int[] nums1,int[] nums2){
        int len = nums1.length;
        HashMap<Integer,Integer> maxMap = new HashMap<>();
        int max = 0,sum=0;
        for(int i=0;i<len;i++){
            int abs=Math.abs(nums1[i]-nums2[i]);
            sum += abs;
            if(abs>max){
                max = abs;
                maxMap.clear();
                maxMap.put(i,max);
            } else if(abs==max){
                maxMap.put(i,max);
            }
        }

        sum-=max;
        for(Integer index:maxMap.keySet()){
            for(int i=0;i<len;i++){
                max = Math.abs(nums1[i]-nums2[index])<max?Math.abs(nums1[i]-nums2[index]):max;
            }
        }
        return (sum+max)/Integer.valueOf((int) Math.pow(10,9)) +7;
    }

    public static void main(String[] args) {
        System.out.println(10^2+7);
    }
}
