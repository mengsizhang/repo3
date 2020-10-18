package com.offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class offer24 {
    /* public ListNode reverseList(ListNode head) {
         ListNode curr = null;
         ListNode prev = head;
         while (prev!=null){//通过局部逆转，最后实现全部逆转
             ListNode t = prev.next;
             prev.next=curr;
             curr=prev;
             prev=t;
         }
         return curr;
     }*/
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);//这里的cur就是最后一个节点
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        head.next = null; //防止链表循环，需要将head.next设置为空
        return cur;//每层递归函数都返回cur，也就是最后一个节点
    }
}
