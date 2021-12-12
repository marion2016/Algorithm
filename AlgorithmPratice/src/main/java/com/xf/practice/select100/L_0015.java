package com.xf.practice.select100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L_0015 {

    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        if (len == 0 || nums[0] > 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int j = i + 1; j < len; j++) {

                if (!map.containsKey(target - nums[j])) {
                    map.put(nums[j], false);
                    continue;
                }

                if (!map.get(target - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    ans.add(list);
                    map.put(target - nums[j], true);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L_0015 ins = new L_0015();
        ins.threeSum(new int[] {0,2,2,3,0,1,2,3,-1,-4,2});
    }
}
