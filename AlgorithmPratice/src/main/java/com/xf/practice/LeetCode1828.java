package com.xf.practice;

import com.xf.practice.utils.Utils;

public class LeetCode1828 {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int len = queries.length;
        int[] res  = new int[len];
        int lenp = points.length;

        for(int i=0;i<len;i++){
            int count = 0;
            int lx=queries[i][0]-queries[i][2];
            int ly=queries[i][1];
            int dx=queries[i][0];
            int dy=queries[i][1]-queries[i][2];
            int rx=queries[i][0]+queries[i][2];
            int ry=queries[i][1];
            int ux=queries[i][0];
            int uy=queries[i][1]+queries[i][2];
            for(int j=0;j<lenp;j++){
                int x = points[j][0];
                int y = points[j][1];

                if(x<rx && x>lx && y<uy && y>dy){
                    count++;
                }else if(x==rx && y==ry){
                    count++;
                }else if(x==lx && y==ly){
                    count++;
                }else if(x==ux && y==uy){
                    count++;
                }else if(x==dx && y==dy){
                    count++;
                }else{

                }
            }
            res[i]=count;
        }

        return res;
    }

    public static void main(String[] args) {
            int[][] p = {{1,3},{3,3},{5,3},{2,2}};
            int[][] q = {{2,3,1},{4,3,1},{1,1,2}};
        int[] res = countPoints(p,q);
        Utils.printArr(res);
    }
}
