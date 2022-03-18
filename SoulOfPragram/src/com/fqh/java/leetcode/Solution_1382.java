package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1382. 将二叉搜索树变平衡
 */
public class Solution_1382 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(17);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        node1.left = node3;
        node1.right = node2;
        node3.left = node4;
        List<Integer> list = new ArrayList<>();
        balanceBST(root);
        System.out.println(height(root.right));
    }

    public static TreeNode balanceBST(TreeNode root) {
        if (height(root.left) - height(root.right) > 1) {
            if (root.left != null && height(root.left.right) > height(root.left.left)) {
                leftRotate(root.left);
                rightRotate(root);
            }else {
                rightRotate(root);
            }
            return root;
        }
        if (height(root.right) - height(root.left) > 1) {
            if (root.right != null && height(root.right.left) > height(root.right.right)) {
                rightRotate(root.right);
                leftRotate(root);
            }else {
                leftRotate(root);
            }
            return root;
        }
        return root;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.left == null ? 0 : height(root.left), root.right == null ? 0 : height(root.right)) + 1;
    }

    //左旋
    public static void leftRotate(TreeNode root) {
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = root.left;
        newNode.right = root.right.left;
        root.val = root.right.val;
        root.right = root.right.right;
        root.left = newNode;
    }

    //右旋
    public static void rightRotate(TreeNode root) {
        TreeNode newNode = new TreeNode(root.val);
        newNode.right = root.right;
        newNode.left = root.left.right;
        root.val = root.left.val;
        root.left = root.left.left;
        root.right = newNode;
    }
}
