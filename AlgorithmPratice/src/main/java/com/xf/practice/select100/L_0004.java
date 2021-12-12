package com.xf.practice.select100;

public class L_0004 {



    public double findMedianSortedArrays_Merge(int[] nums1, int[] nums2) {
        int[] nums3 = merge(nums1, nums2);
        int n = nums3.length;

        if (n % 2 == 0) {
            return (double)(nums3[n / 2] + nums3[n / 2 + 1]) / 2;
        }

        return nums3[n / 2];
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums3 = new int[n1 + n2];

        int index = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] < nums2[i2]) {
                nums3[index++] = nums1[i1];
                i1++;
                continue;
            }
            nums3[index++] = nums2[i2];
            i2++;
        }

        while (i1 < n1) {
            nums3[index++] = nums1[i1++];
        }

        while (i2 < n2) {
            nums3[index++] = nums2[i2++];
        }

        return nums3;
    }

    public static void main(String[] args) {
        L_0004 ins = new L_0004();

    }
}
