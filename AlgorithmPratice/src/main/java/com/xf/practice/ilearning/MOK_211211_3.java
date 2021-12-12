package com.xf.practice.ilearning;

import javafx.util.Pair;

import java.util.*;

/**
 * 思路：题目是二维矩阵题目，要遍历矩阵中的，不是DFS，就是BFS。而题目中提到了要找最短距离，这种情况一般都是使用bfs。因为bfs是按照层搜索的。所以逐层递增，找到的距离一定是最短的距离。
 * 反而如果是dfs的话，需要每个节点都要找一次，然后比较最短距离，时间复杂度一定高。
 *
 * 在考虑了用bfs中，如何操作呢。
 * 1 遍历矩阵所有的零售店，加入到队列
 * 2 依次遍历队列，取队列中一个值，进行bfs，找到最短距离，并记录
 *   一般用矩阵中使用bfs，是从点的四周来扩展，那么就会出现重复的计算，为了避免重复计算，所以需要加入 visised遍历来记录是否已经访问过。
 */
public class MOK_211211_3 {

    int row = 0;
    int col = 0;
    public int getMinSum(int[][] arr) {
        int finalPath = 0;
        row = arr.length;
        col = arr[0].length;

        List<Pair<Integer, Integer>> stores = new LinkedList<>();

        // 找到所有的零售店。
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    stores.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> store : stores) {
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(store);
            visited.add(store.getKey() * col + store.getValue());

            int level = 0;
            boolean find = false;
            while (!queue.isEmpty() && !find) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Pair<Integer, Integer> sto = queue.poll();

                    if (arr[sto.getKey()][sto.getValue()]  == 0) {
                        finalPath += level;
                        find = true;
                        break;
                    }


                    int nextkey = sto.getKey() + 1;
                    int nextvalue = sto.getValue();
                    addQueue(nextkey, nextvalue, arr, visited, queue);

                    nextkey = sto.getKey() - 1;
                    nextvalue = sto.getValue();
                    addQueue(nextkey, nextvalue, arr, visited, queue);

                    nextkey = sto.getKey();
                    nextvalue = sto.getValue() + 1;
                    addQueue(nextkey, nextvalue, arr, visited, queue);

                    nextkey = sto.getKey();
                    nextvalue = sto.getValue() - 1;
                    addQueue(nextkey, nextvalue, arr, visited, queue);
                }
                level++;
            }
        }

        System.out.println("final path is " + finalPath);
        return finalPath;
    }

    public boolean isBeyond(int i, int j) {
        return i < 0 || i >= row || j < 0 || j >= col;
    }

    public void addQueue(int nextkey, int nextvalue, int[][] arr, Set<Integer> visited, Queue<Pair<Integer, Integer>> queue) {
        if (!isBeyond(nextkey, nextvalue) && arr[nextkey][nextvalue] != -1 && !visited.contains(nextkey * col + nextvalue)) {
            queue.add(new Pair<Integer, Integer>(nextkey, nextvalue));
            visited.add(nextkey * col + nextvalue);
        }
    }

    public static void main(String[] args) {
        MOK_211211_3 ins = new MOK_211211_3();
        ins.getMinSum(new int[][] {{1, -1, 0}, {0, 1, 1}, {1, -1, 1}});
        ins.getMinSum(new int[][] {{0, -1, 1}, {1, -1, 1}});

    }
}
