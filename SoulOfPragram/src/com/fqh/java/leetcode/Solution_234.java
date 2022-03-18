package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 234. 回文链表
 */
public class Solution_234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            list.add(cur.val);
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }

        ListNode temp = dummy.next;
        int index = 0;
        while (temp != null) {
            if (list.get(index++) != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
