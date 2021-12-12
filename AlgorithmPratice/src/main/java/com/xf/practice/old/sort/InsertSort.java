package com.xf.practice.old.sort;

public class InsertSort {

    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j+1]<arr[j]){
                    swap(arr,j+1,j);
                } else {
                    break;
                }
            }
        }

    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    private static void printAll(int[] arrs){
        for(int arr:arrs){
            System.out.print(arr);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int[] arr=new int[]{41,24,32,12,53,11,19,31};
        insertSort(arr);
        printAll(arr);
        arr=new int[]{411,224,342,112,503,11,9,21};
        insertSort(arr);
        printAll(arr);

        arr=new int[]{-1,-1,-42,12,53,101,92,21};
        insertSort(arr);
        printAll(arr);

        arr=new int[]{101,92,21};
        insertSort(arr);
        printAll(arr);


        arr=new int[]{0,0,0,1,-9,32};
        insertSort(arr);
        printAll(arr);

        arr=new int[]{0,0,0,1,-9,32,41,24,32,12,53,11,19,31,-1,-1,-42,12,53,101,92,21,411,224,342,112,503,11,9,21};
        insertSort(arr);
        printAll(arr);
    }
}
