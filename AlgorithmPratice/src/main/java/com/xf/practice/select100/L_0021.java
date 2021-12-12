package com.xf.practice.select100;

import utils.ListNode;

public class L_0021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cursor = head;

        while (null != list1 && null != list2) {
            if (list1.val <= list2.val) {
                cursor.next = list1;
                cursor = cursor.next;
                list1 = list1.next;
                continue;
            }

            cursor.next = list2;
            cursor = cursor.next;
            list2 = list2.next;
        }

        finalMerge(list1, cursor);
        finalMerge(list2, cursor);

        return head.next;

    }


    public void finalMerge(ListNode node, ListNode head) {
        while (null != node) {
            head.next = node;
            node = node.next;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        L_0021 ins = new L_0021();

    }
}
