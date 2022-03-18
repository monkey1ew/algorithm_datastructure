package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 876. 链表的中间结点
 */
public class Solution_876 {

    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next == null) {
                return fast;
            }
            if (fast.next.next == null || fast.next.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
