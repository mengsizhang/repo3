package com.learn;

import java.util.ArrayList;
import java.util.List;

public class leet2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count1 = 0;
        int count2 = 0;
        String first = "";
        String second = "";
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            count1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            count2++;
            l2 = l2.next;
        }
        for (int i = count1 - 1; i >= 0; i--) {
            first = first + list1.get(i);
        }
        for (int i = count2 - 1; i >= 0; i--) {
            second = second + list2.get(i);
        }
        Long sum = Long.parseLong(first) + Long.parseLong(second);
        int len = String.valueOf(sum).length();
        char[] numChar = new char[len];
        int[] numInt = new int[len];
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 0; i < len; i++) {
            numChar[i] = String.valueOf(sum).charAt(len - i - 1);
            numInt[i] = Integer.parseInt(String.valueOf(numChar[i]));
            curr.next = new ListNode(numInt[i]);
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(6);
        ListNode list3 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;
        ListNode res = addTwoNumbers(node1, list1);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


