package com.fqh.java.leetcode;

import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 2181. 合并零之间的节点
 */
public class Solution_2181 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(0);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode newHead = mergeNodes(head);

        System.out.println(newHead.val);

    }

    public static ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (fast != null && fast.next != null) {
            if (fast.val == 0) {
                cur.next = new ListNode(0);
                cur = cur.next;
                fast = fast.next;
                continue;
            }else {
                cur.val += fast.val;
            }
            fast = fast.next;
        }
        return dummy;
    }
}
