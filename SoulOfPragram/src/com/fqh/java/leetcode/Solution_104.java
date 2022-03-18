package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 104. 二叉树的最大深度
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3
 **/

public class Solution_104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node;

        int depth = maxDepth(root);
        System.out.println(depth);
    }

    public static int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        if (root.left == null && root.right == null) {
            return 1;
        }
        int depth = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();

            if (n >= 1) {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
//                    System.out.println(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }else {
                break;
            }
        }

        return depth;
    }

}
