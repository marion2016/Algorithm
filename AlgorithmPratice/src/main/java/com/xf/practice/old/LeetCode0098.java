package com.xf.practice.old;

import com.xf.practice.old.utils.TreeNode;

public class LeetCode0098 {
    static long pre = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {

        if(null==root){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(root.val <= pre){
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode tn1= new TreeNode(2);
        TreeNode tn2= new TreeNode(1);
        TreeNode tn3= new TreeNode(4);
        TreeNode tn4= new TreeNode(3);
        TreeNode tn5= new TreeNode(7);
        tn1.left = tn2;
        tn1.right = tn3;
        tn3.left = tn4;
        tn3.right=tn5;

        System.out.println(isValidBST(tn1));

    }
}
