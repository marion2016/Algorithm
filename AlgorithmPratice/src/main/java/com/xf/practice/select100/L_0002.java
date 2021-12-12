package com.xf.practice.select100;

import utils.ListNode;
import utils.Utils;

public class L_0002 {


    int plus = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode root = ans;


        while (null != l1 && null != l2) {
            int sum = (l1.val + l2.val + plus) % 10  ;
            ListNode node = new ListNode(sum);
            plus = (l1.val + l2.val + plus) / 10;
            ans.next = node;
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ans = calcRemain(l1, ans);
        ans = calcRemain(l2, ans);

        if (plus == 1) {
            ans.next = new ListNode(1);
        }

        return root.next;
    }

    public ListNode calcRemain(ListNode node, ListNode ans) {
        while (null != node) {
            int sum = (node.val + plus) % 10;
            ans.next = new ListNode(sum);
            plus = (node.val + plus) / 10;
            ans = ans.next;
            node = node.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        L_0002 ins = new L_0002();
        ins.addTwoNumbers(Utils.makeList(new int[] {9,9,9,9,9,9,9}), Utils.makeList(new int[] {9,9,9,9}) );

    }
}
