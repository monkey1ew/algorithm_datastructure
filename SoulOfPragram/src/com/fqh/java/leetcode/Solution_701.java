package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 701. 二叉搜索树中的插入操作
 */
public class Solution_701 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode newRoot = insertIntoBST(root, 5);
        System.out.println(newRoot.right.left);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        add(root, node);
        return root;
    }

    public static void add(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }

        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
            }else {
                add(root.left, node);
            }
        }
        if (node.val > root.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                add(root.right, node);
            }
        }
    }
}
