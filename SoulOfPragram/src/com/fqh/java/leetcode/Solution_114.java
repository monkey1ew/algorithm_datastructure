package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 114. 二叉树展开为链表
 */
public class Solution_114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        flatten(root);

    }

    public static TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        TreeNode p = root;
        root.left = null;
        root.right = left;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

        return root;
    }
}
