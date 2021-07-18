package com.xf.practice.tree;

import com.xf.practice.utils.TreeNode;
import com.xf.practice.utils.Utils;

public class InOrder {

    public static void doInOrder(TreeNode root){
        if(null == root){
            return ;
        }

        doInOrder(root.left);
        System.out.println(" "+root.val+" ");
        doInOrder(root.right);
    }

    public static void main(String[] args) {
        doInOrder(Utils.getTreeNode());
    }
}
