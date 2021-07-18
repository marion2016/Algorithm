package com.xf.practice;

public class LeetCode0867 {
    public int[][] transpose(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        int[][] newMatrix = new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                newMatrix[j][i]=matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(){

    }
}
