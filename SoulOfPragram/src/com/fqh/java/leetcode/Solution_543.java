package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_543 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return diameter(root);
    }

    public static int diameter(TreeNode root) {
        return Math.max(root.left == null ? 0 : diameter(root.left),  root.right == null ? 0 : diameter(root.right)) + 1;
    }
}
