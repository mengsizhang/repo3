package com.learn;


public class leet19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n + 1; i++) {//第一个指针从哑节点往后移动了n+1位
            first = first.next;
        }
        while (first != null) {//第一个指针和第二个指针又同时向后移动直至第一个指针到达尾结点的下一位
            first = first.next;
            second = second.next;//此时的第二个指针的位置恰好是要删除节点的前一位
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
