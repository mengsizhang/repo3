package com.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class offer22 {
    /*public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0, pl = 1;
        ListNode prev = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        if (k == count) {
            return prev;
        }
        while (prev != null) {
            if (count - k + 1 == pl) {
                return prev;
            }
            prev = prev.next;
            pl++;
        }
        return prev;
    }*/
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;//定义双指针，让前指针走N步，后指针走N-k步
        for (int i = 0; i < k; i++) {
            former = former.next;//前指针与后指针间距k步
        }
        while (former != null) {
            former = former.next;//所以当前指针走到null时,后指针恰好走到倒数第k个位置
            latter = latter.next;
        }
        return latter;
    }
}
