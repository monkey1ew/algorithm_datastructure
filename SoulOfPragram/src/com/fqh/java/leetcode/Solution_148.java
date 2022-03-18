package com.fqh.java.leetcode;

import lombok.val;

import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 148. 排序链表
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Solution_148 {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(sortList(head));

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;   //将链表断开
        ListNode left = sortList(head); //对左边归并排序
        ListNode right  = sortList(temp);   //对右边归并排序
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        while (left != null && right != null) {
            if (left.val < temp.val) {
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right; //如果左链表有剩余元素，就拼接左链表，否则就拼接右链表
        return res.next;
    }
}
