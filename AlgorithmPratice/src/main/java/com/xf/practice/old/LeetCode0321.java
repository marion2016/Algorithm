package com.xf.practice.old;

import com.xf.practice.old.utils.Utils;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode0321 {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
       int[] res = new int[k];


       if(nums1.length + nums2.length == k){
           int[] merge = merge(nums1,nums2);
           res = compare(res,merge)?merge:res;
           Utils.printArr(res);
       } else {
           for(int i=1;i<k;i++){
               int i2 = k-i;
               int[] sub1 = getMaxSub(nums1,i);
               System.out.print(" i is :"+i);
               System.out.print(" sub1 is :");

               Utils.printArr(sub1);
               int[] sub2 = getMaxSub(nums2,i2);
               System.out.print(" i2 is :"+i2);

               System.out.print(" sub2 is :");

               Utils.printArr(sub2);

               //merge sub1 and sub2;
               int[] merge = merge(sub1,sub2);
               System.out.print(" merge is :");
               Utils.printArr(merge);
               System.out.print(" res is :");
               Utils.printArr(res);

               res = compare(res,merge)?merge:res;
               System.out.print(" res is :");

               Utils.printArr(res);
           }
       }



       return res;

    }

    public static boolean compare(int[] nums1,int[] nums2){
        int len = nums1.length;
        boolean flag= false;
        for(int i=0;i<len;i++){
            if(nums2[i]<nums1[i]){
                flag = false;
                break;
            } else if(nums2[i]>nums1[i]){
                flag = true;
                break;
            } else {
                continue;
            }
        }
        return flag;
    }

    public static int[] merge(int[] nums1 ,int[] nums2){
        int len = nums1.length+nums2.length;
        int[] res = new int[len];
        int n=0,m=0;

        for(int i = 0;i<len;i++){
            if(n >= nums1.length && m<nums2.length){
                res[i]= nums2[m];
                m++;
                continue;
            }

            if(m>=nums2.length  && n<nums1.length){
                res[i] = nums1[n];
                n++;
                continue;
            }

            if( m>=nums2.length || nums1[n]>nums2[m]){
                res[i] = nums1[n];
                n++;
            } else if(nums1[n]==nums2[m]){
                if(nums1[n+1]>nums2[m]){
                    res[i] = nums1[n];
                    n++;
                } else {

                }
            } else {
                res[i] = nums2[m];
                m++;
            }
        }
        return res;
    }


    public static int[] getMaxSub(int[] nums,int i){

        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        int remain=i;

        for(int n = 0;n<nums.length;n++){
            while(!stack.isEmpty() && stack.peek() < nums[n]){
                if( len-n > remain){
                    stack.pop();
                    remain++;
                } else {
                    break;
                }
            }
            if(remain>0){
                stack.push(nums[n]);
                remain--;
            }
//            stack.push(nums[n]);
//            remain--;
        }
        return Arrays.stream(stack.toArray(new Integer[]{i})).mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
//        int[] nums1={3,4,6,5};
//        int[] nums2={9,1,2,5,8,3};
//
//        maxNumber(nums1,nums2,5);

        int[] nums11={6,7};
        int[] nums21={6,0,4};

        maxNumber(nums11,nums21,5);
//
////        Utils.printArr(maxNumber(nums1,nums2,5));
//        int[] res = new int[3];
//       // getMaxSub(nums1,2);
//        getMaxSub(nums1,3);
//        getMaxSub(nums1,2);
//        getMaxSub(nums1,1);
//
//        getMaxSub(nums2,4);
//        getMaxSub(nums2,3);
//        getMaxSub(nums2,5);
//        getMaxSub(nums2,2);
//
//        //Utils.printArr(getMaxSub(nums2,3));
//        Stack<Integer> stack = new Stack<>();
//        stack.setSize(2);
//        System.out.println(stack.size());

    }
}
