package com.xf.practice.old.utils;

public class LeetCodeHuawei002 {
    public static int binaryTree(TreeNode root){
        int res = 0;

        return res;
    }

    public void forward(TreeNode node){

    }

    public void middle(TreeNode node){

    }

    public static void main(String[] args) {
        TreeNode tn1= new TreeNode(1);
        TreeNode tn2= new TreeNode(7);
        TreeNode tn3= new TreeNode(3);
        TreeNode tn4= new TreeNode(2);
        TreeNode tn5= new TreeNode(6);
        TreeNode tn6= new TreeNode(5);
        TreeNode tn7= new TreeNode(4);
        TreeNode tn8= new TreeNode(7);
        TreeNode tn9= new TreeNode(9);
        TreeNode tn10= new TreeNode(10);
        TreeNode tn11= new TreeNode(6);

        tn1.left = tn2;
        tn1.right  = tn6;

        tn2.left = tn3;
        tn3.left = tn4;
        tn4.left = tn5;

        tn6.right  = tn7;
        tn7.left = tn8;
        tn7.right = tn11;

        tn8.left = tn9;
        tn8.right = tn10;


        binaryTree(tn1);


    }

}
