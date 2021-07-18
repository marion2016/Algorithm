package com.xf.practice.utils;

public class Utils {

    public static ListNode makeList(int[] arrs){
        ListNode ln = new ListNode();
        ListNode tmp = ln;

        for(int i=0;i<arrs.length;){
            tmp.val = arrs[i];
            tmp.next = i+1<arrs.length?new ListNode(arrs[i+1]):null;
            tmp = tmp.next;
            i++;
        }
        return ln;
    }

    public static TreeNode createNode(int[] arrs,int index){
        TreeNode tn = null;
        if(index<arrs.length){
            tn  = new TreeNode(arrs[index]);
            tn.left = createNode(arrs,2*index +1);
            tn.right = createNode(arrs,2*index+2);

        }
        return tn;
    }

    public static void printArr(int[] nums){
        for(int num:nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void printArr(Integer[] nums){
        for(Integer num:nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static TreeNode getTreeNode(){
        TreeNode tn1= new TreeNode(2);
        TreeNode tn2= new TreeNode(1);
        TreeNode tn3= new TreeNode(4);
        TreeNode tn4= new TreeNode(3);
        TreeNode tn5= new TreeNode(7);
        tn1.left = tn2;
        tn1.right = tn3;
        tn3.left = tn4;
        tn3.right=tn5;
        return  tn1;

    }

    public static TreeNode arr2tree(Object[] arrs){

        int count = arrs.length;

        TreeNode root = new TreeNode((Integer)arrs[0]);
        TreeNode cur = root;
        int i = 0;
        while(count>0){
            int pl = 2*i+1;
            int pr = 2*i+2;
            if(pl<arrs.length){
                cur.left  = new TreeNode((Integer)arrs[pl]);
                count--;
            }
            if(pr<arrs.length){
                cur.right = new TreeNode((Integer)arrs[pr]);
                count--;
            }
            i++;
        }

        return root;
    }

    public static Node arr2treeNode(Object[] arrs){
        int delta = 0;

        if(null == arrs || arrs.length == 0 ){
            return null;
        }

        Node[] nodes = new Node[arrs.length];
        nodes[0] = new Node((Integer)arrs[0]);
        int rootIndex = 0;
        Node node;

        for(int i = 1;i<arrs.length;i++){
            node = null == arrs[i]?null:new Node((Integer)arrs[i]);

            if(i%2==1){
                rootIndex = (i-1)/2+delta;
                while(null == nodes[rootIndex]){
                    rootIndex++;
                    delta++;
                }
                nodes[rootIndex].left= node;
            } else {
                rootIndex = (i-2)/2+delta;
                while(null == nodes[rootIndex]){
                    rootIndex++;
                    delta++;
                }
                nodes[rootIndex].right= node;
            }

            nodes[i]= node;
        }
        return nodes[0];

    }

    public static void  main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12};
        Utils utils = new Utils();
        TreeNode tn = Utils.createNode(arr,0);
        ListNode ln = Utils.makeList(arr);
        System.out.println(tn.val);
        System.out.println(ln.val);
    }
}
