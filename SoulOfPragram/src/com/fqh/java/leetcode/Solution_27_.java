package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 剑指 Offer II 027. 回文链表
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 */
public class Solution_27_ {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode cur = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val);
            cur = cur.next;
        }
        String s1 = stringBuilder.toString();
        String s2 = stringBuilder.reverse().toString();
        return s1.equals(s2);
    }
}
