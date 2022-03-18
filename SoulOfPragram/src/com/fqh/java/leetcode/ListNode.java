package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node(" +
                "val=" + val +")";
    }
}
