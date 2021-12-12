package com.xf.practice.ilearning;

import java.util.ArrayList;
import java.util.List;

/*

 */
public class MOK_211211_1 {

    /**
     * 备忘录算法，采用2次遍历方法
     * 第一遍遍历，左右指针，通过dp[i][2] ，标示i位置的经历过的最大值，和最小值 0 最小值， 1 最大值
     * 左指针遍历后，记录最大值，右指针遍历后记录最小值。
     * 如果左指针遍历的时候，比前面的最大值大说明，左边的数据都比自己小，则 dpb[0] 为true，否则为false；
     * 如果右指针遍历的时候，比后面的最小值小说明，右边的数据都比自己大，则 dpb[1] 为true，否则为false；
     *
     * 第二遍遍历dpb，如果dpb[1]和[0]均为true，则符合 主元的条件。返回当前结果
     *
     * 初始化条件：
     * 第一个元素dp[0][0]  = true;
     * 最后一个元素 dpb[len - 1][1] = true;
     *
     * dp[i][2] 标示，i位置的最大值，和最小值
     * @param nums
     *
     */

    public int[] findBaseNums_dp(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2]; // 0 最小值， 1 最大值
        boolean[][] dpb = new boolean[len][2];

        dp[0][1] = nums[0];
        dp[len - 1][0] = nums[len - 1];
        dpb[0][0] = true;
        dpb[len - 1][1] = true;

        for (int i = 1; i < len; i++) {
            int tail = len - 1 - i;
            if (nums[i] > dp[i - 1][1]) {
                dp[i][1] = nums[i];
                dpb[i][0] = true;
            } else {
                dp[i][1] = dp[i - 1][1];
                dpb[i][0] = false;
            }

            if (nums[tail] < dp[len - i][0]) {
                dp[tail][0] = nums[tail];
                dpb[tail][1] = true;
            } else {
                dp[tail][0] = dp[len - i][0];
                dpb[tail][1] = false;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (dpb[i][0] && dpb[i][1]) {
                ans.add(nums[i]);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MOK_211211_1 ins = new MOK_211211_1();
        ins.findBaseNums_dp(new int[] {1,3,2,4,5}); // 1, 4, 5
        ins.findBaseNums_dp(new int[] {7,7,7,7,7,7,7}); // 5,7,8,9
        ins.findBaseNums_dp(new int[] {7,8,9,10,11,12,13}); // 5,7,8,9
        ins.findBaseNums_dp(new int[] {7,7,7,7,11,12,13}); // 5,7,8,9
        ins.findBaseNums_dp(new int[] {1,5,4,6,2,7,8}); // 5,7,8,9
        ins.findBaseNums_dp(new int[] {2,5,4,6,1,7,8}); // 5,7,8,9

    }
}
