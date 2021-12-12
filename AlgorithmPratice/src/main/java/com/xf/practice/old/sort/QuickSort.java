package com.xf.practice.old.sort;

public class QuickSort {

    /**
     * Step1 ：选择基准，将小于基准的放置在前方，大于基准的放置在后方
     * Step2 ：将左方的进行递归
     * Step3 ：将右方的进行递归
     */
    public static void quickSort(int[] arr,int l,int r){
        if(l<r){
            int p = partitiion(arr,l,r);
            quickSort(arr,l,p);
            quickSort(arr,p+1,r);
        }
    }

    /**
     * Step1: 将数组的第一个值作为基准
     * Step2:
     * @return
     */
    public static int partitiion(int[] arr,int P,int N){

        while(N!=P){
            if(P<N){
                if(arr[P]>arr[N]){
                    int tmp = arr[N];
                    arr[N]=arr[P];
                    arr[P]=tmp;
                    tmp=N;
                    N=P+1;
                    P=tmp;
                }else {
                    N--;
                }
            }else {
                if(arr[P]<arr[N]){
                    int tmp = arr[N];
                    arr[N]=arr[P];
                    arr[P]=tmp;
                    tmp=N;
                    N=P-1;
                    P=tmp;
                } else {
                    N++;
                }
            }
        }

        return N;
    }

    private static void printAll(int[] arrs){
        for(int arr:arrs){
            System.out.print(arr);
            System.out.print(" ");
        }
        System.out.println("");
    }


    private static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }


    public static void main(String[] args){
        int[] arr=new int[]{41,24,32,12,53,11,19,31};
        quickSort(arr,0,arr.length-1);
        printAll(arr);
        arr=new int[]{411,224,342,112,503,11,9,21};
        quickSort(arr,0,arr.length-1);
        printAll(arr);

        arr=new int[]{-1,-1,-42,12,53,101,92,21};
        quickSort(arr,0,arr.length-1);
        printAll(arr);

        arr=new int[]{101,92,21};
        quickSort(arr,0,arr.length-1);
        printAll(arr);


        arr=new int[]{0,0,0,1,-9,32};
        quickSort(arr,0,arr.length-1);
        printAll(arr);

        arr=new int[]{0,0,0,1,-9,32,41,24,32,12,53,11,19,31,-1,-1,-42,12,53,101,92,21,411,224,342,112,503,11,9,21};
        quickSort(arr,0,arr.length-1);
        printAll(arr);
    }
}
