package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 1019. 链表中的下一个更大节点
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 */
public class Solution_1019 {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        nextLargerNodes(head);
    }
    /** 单调栈 */
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
