package com.offer;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;//当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；
            node2 = node2 != null ? node2.next : headA;//当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
        }
        return node1;//当它们相遇时，所指向的结点就是第一个公共结点,不相交的情况下，公共节点是null,所以相遇节点是null
    }
}
