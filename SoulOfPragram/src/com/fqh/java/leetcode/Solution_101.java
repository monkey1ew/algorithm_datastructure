package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 101. 对称二叉树
 */
public class Solution_101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
