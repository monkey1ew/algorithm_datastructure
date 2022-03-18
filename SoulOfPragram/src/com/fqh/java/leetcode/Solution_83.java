package com.fqh.java.leetcode;

import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class Solution_83 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode resNode = deleteDuplicates(head);
        System.out.println(resNode);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;

        }
        ListNode newHead = new ListNode();
        ListNode temp = head;
        ListNode cur = newHead;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }else {
                cur.next = temp;
                cur = cur.next;
                temp = temp.next;
            }
        }
        return newHead.next;
    }
}
