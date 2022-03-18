package com.fqh.java.leetcode;

import java.util.ArrayList;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 404. 左叶子之和
 */
public class Solution_404 {
    private static int sum = 0;
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

        int sum = sumOfLeftLeaves(root);

        System.out.println(sum);

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
