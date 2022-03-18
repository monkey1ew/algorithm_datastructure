package com.fqh.java.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 24.
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class Solution_24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode resNode = swapPairs(head);
        System.out.println(resNode);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode p = new ListNode();

        ListNode cur = head;
        head = p;
        while (cur != null && cur.next != null) {
            stack.push(cur);
            stack.push(cur.next);

            cur = cur.next.next;
            p.next = stack.pop();
            p = p.next;

            p.next = stack.pop();
            p = p.next;

        }
        if (cur != null) {
            p.next = cur;
        }else {
            p.next = null;
        }
        return head;
    }
}
