package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 671. 二叉树中第二小的节点
 */
public class Solution_671 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        int value = findSecondMinimumValue(root);
        System.out.println(value);
    }

    public static int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        if (set.size() == 1) {
            return -1;
        }
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> (
                o2 - o1
                )));
        for (int n : set) {
            pq.offer(n);
            if (pq.size() > 2) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
}
