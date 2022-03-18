package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 */
public class Solution_21 {

    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n - 1; i++){
            fast = fast.next;
        }
        while(true){
            if(fast.next == null){
                return head.next;
            }
            if(fast.next.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;

        }
        slow.next = slow.next.next;
        return head;
    }
}
