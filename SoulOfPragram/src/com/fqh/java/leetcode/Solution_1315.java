package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 1315. 祖父节点值为偶数的节点和
 */
public class Solution_1315 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node4.left = node8;
        node4.right = node9;
        node6.right = node10;

        System.out.println(sumEvenGrandparent(root));
    }


    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                if (node.val % 2 == 0) {
                    if (node.left != null) {
                        if (node.left.left != null) {
                            sum += node.left.left.val;
                        }
                        if (node.left.right != null) {
                            sum += node.left.right.val;
                        }
                    }
                    if (node.right != null) {
                        if (node.right.right != null) {
                            sum += node.right.right.val;
                        }
                        if (node.right.left != null) {
                            sum += node.right.left.val;
                        }
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
}
