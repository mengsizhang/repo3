package com.learn;


public class leet24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            preNode.next = first.next;
            first.next = second.next;
            second.next = first;

            preNode = first;
            head = first.next;
        }
        return dummy.next;
    }
}
