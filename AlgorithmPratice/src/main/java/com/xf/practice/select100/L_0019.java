package com.xf.practice.select100;

import utils.ListNode;
import utils.Utils;

public class L_0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode PRE = new ListNode();
        PRE.next = head;
        ListNode FIR = PRE;
        ListNode SEC = PRE;

        n = n + 1;
        while (n > 0 && null != FIR) {
            FIR = FIR.next;
            n--;
        }

        while (null != FIR) {
            FIR = FIR.next;
            SEC = SEC.next;
        }

        ListNode node = SEC.next.next;
        SEC.next = node;

        return PRE.next;

    }

    public static void main(String[] args) {
        L_0019 ins = new L_0019();
        ins.removeNthFromEnd(Utils.arrs2ListNode(new Object[] {1,2,3,4,5}), 1);
        ins.removeNthFromEnd(Utils.arrs2ListNode(new Object[] {1,2,3,4,5}), 2);

        ins.removeNthFromEnd(Utils.arrs2ListNode(new Object[] {1}), 1);
    }
}
