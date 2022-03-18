package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 02.07. 链表相交
 */
public class Solution_02_ {

    public static void main(String[] args) {

    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            if (p == null) {
                p = headB;
            }else {
                p = p.next;
            }

            if (q == null) {
                q = headA;
            }else {
                q = q.next;
            }
        }

        return p;
    }
}
