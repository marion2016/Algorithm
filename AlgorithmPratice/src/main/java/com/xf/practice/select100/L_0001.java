package com.xf.practice.select100;

import java.util.HashMap;

public class L_0001 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};

                }
            }
        }
        return new int[0];
    }

    public int[] twoSumPlus(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        L_0001 ins = new L_0001();
        ins.twoSumPlus(new int[] {2,7,11,15}, 9);

    }
}
