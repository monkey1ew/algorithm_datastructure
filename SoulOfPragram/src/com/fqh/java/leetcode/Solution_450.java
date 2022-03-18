package com.fqh.java.leetcode;

import java.util.TreeMap;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 450. 删除二叉搜索树中的节点
 */
public class Solution_450 {
    static TreeNode root = new TreeNode(5);
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(7);
        root.left = node;
        node.left = node1;
        node.right = node2;
        root.right = node3;
        node3.right = node4;

        TreeNode newRoot = deleteNode(root, 3);
        System.out.println(newRoot);

    }

    public static int delRightTreeMin(TreeNode node) {
        TreeNode target = node;
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(root, target.val);
        return target.val;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }else {
            //目标节点
            TreeNode targetNode = search(root, key);
            if (targetNode == null) {
                return root;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }
            TreeNode parent = searchParent(root, key);
            System.out.println(parent);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.val == key) {
                    parent.left = null;
                }else if (parent.right != null && parent.right.val == key) {
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null) {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.val = minVal;
            }else {
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.val == key) {
                            parent.left = targetNode.left;
                        }else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if (parent != null) {
                        if (parent.left.val == key) {
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;

                    }
                }
            }
        }
        return root;
    }


    public static TreeNode search(TreeNode root, int value) {
        if (root.val == value) {
            return root;
        }else if (value < root.val) {
            if (root.left == null) {
                return null;
            }
            return search(root.left, value);
        }else {
            if (root.right == null) {
                return null;
            }
            return search(root.right, value);
        }
    }

    public static TreeNode searchParent(TreeNode root, int value) {
        if (root.left != null && root.left.val == value ||
        root.right != null && root.right.val == value) {
            return root;
        }else {
            if (value < root.val && root.left != null) {
                return searchParent(root.left, value);
            }else if (value > root.val && root.right != null) {
                return searchParent(root.right, value);
            }else {
                return null;
            }
        }
    }
}
