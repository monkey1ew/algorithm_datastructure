package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1669. 合并两个链表
 */
public class Solution_1669 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head2 = new ListNode(100000);
        ListNode node6 = new ListNode(100001);
        ListNode node7 = new ListNode(100001);
        head2.next = node6;
        node6.next = node7;

        ListNode mergeInBetween = mergeInBetween(head1, 3, 4, head2);
        System.out.println(mergeInBetween);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode begin = list1; //辅助指针指向前面应该连接到的点
        ListNode end = list1;   //辅助指针指向后面应该连接到的点
        ListNode cur = list2;

        for (int i = 0; i < a - 1; i++) {
            begin = begin.next;
        }

        for (int i = 0; i < b + 1; i++) {
            end = end.next;
        }
        begin.next = list2; //开始连接
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = end; //将list最后的元素指向end
        return list1;
    }
}
