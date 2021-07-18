package com.xf.practice;

public class PrimeNumber {

    private static void debug(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args){
        int end= 100000;
        if(end<=0){
            debug("error");
        }
        if(end<=3){
            debug(String.valueOf(end));
        }
        //求质数
        int[] arr = new int[end+1];
        int count=0;
        for(int index=2;index<end;index++){
            int mul=2;
            int mulp=0;
            while(end>=(index*mul) ){
                mulp=index*mul;
                count++;
                arr[mulp]=1;
                mul++;
            }
        }

        int countj=0;
        for(int index=2;index<end+1;index++){
            if(arr[index]==0){
                debug(String.valueOf(index)+"-"+countj);
                countj++;
            }
        }

    }
}
