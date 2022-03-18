package com.fqh.java.leetcode;

import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */
public class Solution_203 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode resNode = removeElements(head, 6);
        System.out.println(resNode);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode temp = newHead;
        ListNode cur = head;

        while (cur != null) {
            if(cur.val == val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
            cur = cur.next;
        }

        return newHead.next;
    }
}
