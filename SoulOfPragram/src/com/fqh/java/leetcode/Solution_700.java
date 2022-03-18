package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 700. 二叉搜索树中的搜索
 */
public class Solution_700 {

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

        System.out.println(searchBST(root, 2));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            if (root.left != null) {
                return searchBST(root.left, val);
            }
        }else {
            if (root.right != null) {
                return searchBST(root.right, val);
            }
        }
        return null;
    }
}
