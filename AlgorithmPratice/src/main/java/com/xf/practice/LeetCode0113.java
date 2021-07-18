package com.xf.practice;

import com.xf.practice.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LeetCode0113 {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<Integer> list = new ArrayList<>();
        int sum=0;
        List<List<Integer>> resList = new ArrayList<>();
        dfs(root,list,sum,targetSum,resList);
        return resList;
    }

    public static void dfs(TreeNode node ,List<Integer> list, int sum,int targetSum,List<List<Integer>> resList){
        if(null == node){
            return ;
        }

        list.add(node.val);
        sum+=node.val;

        if(null == node.right && null == node.left && targetSum == sum){
            resList.add(list.stream().collect(Collectors.toList()));
            return ;
        }

        if(null != node.left){
            dfs(node.left,list,sum,targetSum,resList);
            list.remove(list.size()-1);
        }

        if(null != node.right){
            dfs(node.right,list,sum,targetSum,resList);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
//        TreeNode tn1 = new TreeNode(5);
//        TreeNode tn2 = new TreeNode(4);
//        TreeNode tn3 = new TreeNode(8);
//        TreeNode tn4 = new TreeNode(11);
//        TreeNode tn5 = new TreeNode(13);
//        TreeNode tn6 = new TreeNode(4);
//        TreeNode tn7 = new TreeNode(7);
//        TreeNode tn8 = new TreeNode(2);
//        TreeNode tn9 = new TreeNode(5);
//        TreeNode tn10 = new TreeNode(1);
//
//        tn1.left = tn2;
//        tn1.right = tn3;
//        tn2.left = tn4;
//        tn4.left = tn7;
//        tn4.right = tn8;
//        tn3.left = tn5;
//        tn3.right = tn6;
//        tn6.left = tn9;
//        tn6.right = tn10;


//        TreeNode tn1 = new TreeNode(1);
//        TreeNode tn2 = new TreeNode(2);
//        TreeNode tn3 = new TreeNode(3);
//
//        tn1.left = tn2;
//        tn1.right = tn3;

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);

        tn1.left = tn2;

        System.out.println(pathSum(tn1,0));
    }

}
