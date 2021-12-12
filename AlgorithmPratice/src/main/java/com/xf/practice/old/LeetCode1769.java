package com.xf.practice.old;

import com.xf.practice.old.utils.Utils;

public class LeetCode1769 {

    public static int[] minOperations(String boxes) {

        int len =  boxes.length();
        int[] res = new int[len];
        int[] resL = new int[len];
        int[] resR = new int[len];

        int sum=0,count=0;

       // boxes.toCharArray();

        for(int i = 0;i<len;i++){
            if(boxes.charAt(i) == '1'){
                count+=1;
                sum+=i;
            }
        }

        int L,R,LC=0,RC=count-(boxes.charAt(0)-48);
        resL[0] = 0;
        resR[len-1] = sum;
        res[0] = resL[0] + resR[len-1];

        for(int i=1;i<len;i++){
            L=i;
            //LC=0;
            R=len-L-1;
            //RC=count-LC-(boxes.charAt(i)-48);
            int bfc = boxes.charAt(i-1)-48;
            int cur = boxes.charAt(i)-48;

            if(bfc == 1 && cur == 1 ){
                LC+=1;
                RC-=1;
                resR[i]-=1;
            } else if (bfc == 1 && cur == 0){
                LC+=1;
            } else if (bfc == 0 && cur == 1){
                RC-=1;
            }
            resL[i] = resL[i-1] + LC;
            resR[i] = resR[R+1] - RC;
            res[i] = resL[i] + resR[i];
        }

        return res;
    }

    public static void main(String[] args) {
        String boxes = "110";
        Utils.printArr(minOperations(boxes));
        //System.out.println(minOperations(boxes));
    }
}
