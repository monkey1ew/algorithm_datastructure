package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1325. 删除给定值的叶子节点
 */
public class Solution_1325 {

    public static void main(String[] args) {

    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {

        return remove(root, target);
    }

    public static TreeNode remove(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = remove(root.left, target);
        root.right = remove(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
