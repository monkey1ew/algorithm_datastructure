package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 110. 平衡二叉树
 */
public class Solution_110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        boolean flag = isBalanced(root);
        System.out.println(flag);

    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(root.left == null ? 0 : height(root.left),
                root.right == null ? 0 : height(root.right)) + 1;
    }
}
