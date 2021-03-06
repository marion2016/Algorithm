package com.xf.practice.old;

import java.util.Arrays;

public class LeetCode1838 {
    public static int maxFrequency(int[] nums, int k) {
        int res=1;
        long tmpsum=0,sum=nums[0];
        //step1 sort the arrays
        Arrays.sort(nums);

        int i =0,j=1;

        while(j<nums.length){
            sum += nums[j];
            int count = j-i+1;
            tmpsum = count * nums[j];
            res = Math.max(res,j-i+1);

            if(tmpsum-sum<k){

                j++;
            } else {
                sum-=nums[i];

                i++;
                j++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {9954,9937,9948,9997,9995,9943,9949,9960,9930,9960,9979,9976,9967,9970,9968,9910,9928,9916,9919,9938,9961,9929,9975,9955,9951,9900,9936,9984,9998,9925,9904,9951,9929,9907,9958,9987,9918,9909,9936,9973,9906,9903,9908,9993,9917,9988,9956,9992,9997,9979,9996,9960,9921,9909,9948,9900,9916,9984,9929,9971,9941,9978,9923,9917,9948,9959,9951,9983,9979,9989,9971,9999,9906,9965,9934,9952,9936,9938,9932,9999,9901,9979,9920,9966,9964,9964,9939,9988,9933,9911,9915,9996,9913,9945,9939,9977,9991,9967,9980,9986,9988,9985,9959,9983,9932,9982,9969,9998,9940,9961,9981,9954,9920,9979,9992,9963,9907,9930,9954,9913,9945,9965,9926,9973,9980,9986,9929,9998,9953,9953,9944,9949,9949,9949,9980,9990,9922,9924,9956,9982,9951,9969,9908,9964,9981,9961,9982,9997,9929,9947,9917,9964,9902,9971,9925,9997,9901,9931,9908,9955,9901,9927,9934,9964,9927,9908,9910,9983,9994,9996,9946,9923,9918,9960,9900,9911,9989,9991,9976,9919,9935,9953,9944,9954,9969,9991,9954,9949,9995,10000,9901,9965,9946,9972,9980,9961,9948,9960,9964,9963,9940,9922,9937,9999,9924,9903,9921,9956,9997,9979};
        int ka = 2541;
        System.out.println(maxFrequency(a,ka));


        int[] numss={9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        int kk = 3056;
        System.out.println(maxFrequency(numss,kk));


        int[] nums={1,4,8,13};
        int k = 5;
        System.out.println(maxFrequency(nums,k));

        int[] nums1={1,2,4};
        int k1 = 5;
        System.out.println(maxFrequency(nums1,k1));

        int[] nums2={3,1,10,9,2,4};
        int k2 = 10;
        System.out.println(maxFrequency(nums2,k2));

        int[] nums3={3,9,6};
        int k3 = 2;
        System.out.println(maxFrequency(nums3,k3));
    }
}
