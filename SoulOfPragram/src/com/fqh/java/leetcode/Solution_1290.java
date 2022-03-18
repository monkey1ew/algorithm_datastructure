package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1290. 二进制链表转整数
 */
public class Solution_1290 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;

        int decimalValue = getDecimalValue(head);
        System.out.println(decimalValue);

    }

    public static int getDecimalValue(ListNode head) {
        if (head.val == 0 && head.next == null) {
            return 0;
        }

        ListNode cur = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val);
            cur = cur.next;
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
