package com.xf.practice.old;

public class LeetCode0002 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        while(l1!=null || l2!=null){
            int l1val = null==l1?0:l1.val;
            int l2val = null==l2?0:l2.val;

            int sum = l1val + l2val;
            int carry = sum/10;
            sum = sum%10;

            l4.next=new ListNode(sum);
            if(l1!=null){
                l1=l1.next;
            }

            if(l2!=null){
                l2=l2.next;
            }

            l4= l4.next;
           if(carry==1){
               l4.next = new ListNode(carry);
           }
        }

        return l3.next;
    }

    public static void main(String[] args){
        ListNode l1= new ListNode(2);
        ListNode l2= new ListNode(4);
        ListNode l3= new ListNode(3);
        ListNode l4= new ListNode(5);
        ListNode l5= new ListNode(6);
        ListNode l6= new ListNode(7);

        l1.next=l2;
        l2.next=l3;
        l4.next=l5;
        l5.next=l6;

        addTwoNumbers(l1,l4);

    }
}
