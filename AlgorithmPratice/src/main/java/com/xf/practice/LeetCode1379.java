package com.xf.practice;

import com.xf.practice.utils.TreeNode;

public class LeetCode1379 {


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        //Step1: 判断当前节点是否匹配target
        //Step2: 获取left，right。
        //Step3：判断left，right是否为null，如果为null，则啥也不干

        int res = target.val;
        TreeNode node = null;
        if(null != cloned){

            if(res == cloned.val){
                return cloned;
            } else {
                node = getTargetCopy(original,cloned.left,target);
                node = getTargetCopy(original,cloned.right,target);
            }

        }

        return node;
    }
}
