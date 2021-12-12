package com.xf.practice.old;

import com.xf.practice.old.utils.Node;
import com.xf.practice.old.utils.Utils;

import java.util.LinkedList;

public class LeetCode0116 {

    public static Node connect(Node root) {
        if(null == root){
            return null;
        }
        LinkedList<Node> list = new LinkedList<Node>();
        bfs2(root,list,1,-1,root);
        return root;
    }


    public static void bfs(Node node,LinkedList<Node> list,int level,int count){
        count++;
        //下面这段代码主要是用于控制当前节点是否指向null
        if(count == (1<<level) -2){
            node.next = null;
            level++;
        } else {
            node.next = list.get(0);
        }

        if(null != node.left && null != node.right){
            list.add(node.left);
            list.add(node.right);
        }

        if(list.size()==0){
            return;
        }
        node = list.poll();
        bfs(node,list,level,count);
    }

    public static void bfs2(Node node,LinkedList<Node> list,int level,int count,Node pre){

        count++;
        //下面这段代码主要是用于控制当前节点是否指向null
        if(count == (1<<level) -2){
            if(null != node){
                node.next = null;
            }
            level++;
        } else {
            if(null == node){
                if(null !=pre && count !=((1<<(level-1))-1)){
                    pre.next = list.get(0);
                }
            } else {
                node.next = list.get(0);
            }
        }

        if(null == node){
            count+=2;
        }

        if(null != node && (null != node.left || null != node.right)){
            list.add(node.left);
            list.add(node.right);
        }

        if(list.size()==0){
            return;
        }

        Node cur = list.poll();
        bfs2(cur,list,level,count,node);
    }

    public static void main(String[] args) {
//        Object[] arrs = {1,2,3,4,5,6,7};
//        connect(Utils.arr2treeNode(arrs));

        Object[] arrs2 = {1,null,2,null,2};
        connect(Utils.arr2treeNode(arrs2));
    }
}
