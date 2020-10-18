package com.offer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode prev = head;
        while (prev != null) {
            prev = prev.next;
            dummy=dummy.next;
            if (prev.val == val) {
              dummy.next=prev.next;
              break;
            }
        }
        return head;
    }
}
