package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 剑指 Offer II 022. 链表中环的入口节点
 */
public class Solution_22 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        ListNode node = detectCycle(head);
        System.out.println(node);

    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag) {
            slow = head;
            while (true) {
                if (fast == slow) {
                    return slow;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }else {
            return null;
        }
    }
}
