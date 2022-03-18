package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 111. 二叉树的最小深度
 * BFS
 */
public class Solution_111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        int minDepth = minDepth(root);
        System.out.println(minDepth);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {

            int n = queue.size();
            if (n >= 1) {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        if (node.left == null && node.right == null) {
                            minDepth++;
                            return minDepth;
                        }
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                minDepth++;
            }else {
                break;
            }
        }
        return minDepth;
    }
}
