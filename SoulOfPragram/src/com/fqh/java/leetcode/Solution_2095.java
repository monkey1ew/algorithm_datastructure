package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 2095. 删除链表的中间节点
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 */
public class Solution_2095 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode newHead = deleteMiddle(head);

    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast.next == null) {
                return null;
            }
            if (fast.next.next == null || fast.next.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;


    }
}
