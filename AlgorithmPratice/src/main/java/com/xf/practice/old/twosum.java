package com.xf.practice.old;

import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class twosum {

    /**
     * 暴力遍历
     * @param arr1
     * @param target
     */
    public static void twoSum01(int[] arr1,int target){
        if(arr1.length==0){
            return ;
        }
        for(int i=0;i<arr1.length;i++){
            for(int j=i+1;j< arr1.length;j++){
                if(arr1[i]+arr1[j]==target){
                    System.out.println("index1:"+i+":"+arr1[i]);
                    System.out.println("index2:"+j+":"+arr1[j]);
                }
            }
        }
    }

    /**
     * 使用hashmap两遍遍历
     * @param arr1
     * @param target
     */
    public static void twoSum02(int[] arr1,int target){
        final AtomicInteger autoInt = new AtomicInteger(0);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int arr:arr1){
              map.put(arr,autoInt.intValue());
              autoInt.getAndIncrement();
        }

        map.keySet().stream().forEach(item ->{
            int devide = target - item;
            if(map.containsKey(devide)){
                System.out.println("index1:"+map.get(item)+":"+item);
                System.out.println("index2:"+map.get(devide)+":"+devide);
            }
        });

    }


    /**
     * 使用hashmap一遍遍历
     * @param arr1
     * @param target
     */
    public static void twoSum03(int[] arr1,int target){
        final AtomicInteger autoInt = new AtomicInteger(0);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int arr:arr1){
            int devide = target - arr;
            System.out.println("arr:"+arr+":index"+autoInt.intValue());
            if(map.size()==0){

                map.put(arr,autoInt.intValue());
            }
            if(map.containsKey(devide)){
                System.out.println("index1:"+map.get(arr)+":"+arr);
                System.out.println("index2:"+map.get(devide)+":"+devide);
            }

            map.put(arr,autoInt.intValue());
            autoInt.getAndIncrement();
        }
    }

    public static void main(String[] args){
//        int[] arr={2,4,5,7};
//        twoSum01(arr,7);

        int[] arr2 = {12,21,35,47,52,66,74,8,9,10};
//        twoSum01(arr2,21);
//        twoSum02(arr2,21);
        twoSum03(arr2,21);
    }
}
