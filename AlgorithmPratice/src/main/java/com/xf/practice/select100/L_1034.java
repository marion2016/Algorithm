package com.xf.practice.select100;

public class L_1034 {

    int origin;
    int color;
    int[][] amounts = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.origin = grid[row][col];
        this.color = color;
        dfs(grid, row, col);
        return grid;
    }

    public void dfs(int[][] grid, int row, int col) {
        if ((row ==0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) && grid[row][col] == origin) {
            grid[row][col] = color;
            return;
        }

        if ((row ==0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) || grid[row][col] != origin) {
            return;
        }

        for (int[] amount : amounts) {
            dfs(grid, row + amount[0], col + amount[1]);
        }
    }

    public static void main(String[] args) {
        L_1034 ins = new L_1034();

    }
}
