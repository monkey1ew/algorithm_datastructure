package com.fqh.java.leetcode;

import lombok.var;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 235. 二叉搜索树的最近公共祖先
 *
 */
public class Solution_235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(0);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(5);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(9);

        root.right = node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node4.left = node5;
//        node4.right = node6;
//        node2.left = node7;
//        node2.right = node8;

        TreeNode commonParent = lowestCommonAncestor(root, node1, root);
        System.out.println(commonParent);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pNode = search(root, p.val);
        TreeNode qNode = search(root, q.val);

        TreeNode parent1 = searchParent(root, p.val);
        TreeNode parent2 = searchParent(root, q.val);

        if (parent1 == parent2) {
            return parent1;
        }else if (parent2 == pNode) {
            return pNode;
        }else if (parent1 == qNode) {
            return qNode;
        }
        return null;
    }

    public static TreeNode search(TreeNode root, int value) {
        if (root.val == value) {
            return root;
        }else if (value < root.val) {
            if (root.left == null) {
                return null;
            }
            return search(root, value);
        }else {
            if (root.right == null) {
                return null;
            }
            return search(root.right, value);
        }
    }

    public static TreeNode searchParent(TreeNode root, int value) {
        if (root.left != null && root.left.val == value
                || root.right != null && root.right.val == value) {
            return root;

        }else if (value < root.val) {
            if (root.left == null) {
                return null;
            }
            return searchParent(root.left, value);
        }else {
            if (root.right == null) {
                return null;
            }
            return searchParent(root.right, value);
        }
    }
}
