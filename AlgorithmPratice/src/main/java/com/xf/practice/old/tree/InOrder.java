package com.xf.practice.old.tree;

import com.xf.practice.old.utils.TreeNode;
import com.xf.practice.old.utils.Utils;

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
