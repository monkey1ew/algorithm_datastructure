package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 108. 将有序数组转换为二叉搜索树
 */
public class Solution_108 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};

        TreeNode root = sortedArrayToBST(nums);
        preOrder(root);
//        System.out.println(treeNode);

    }
    public static void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("BST is null");
            return;
        }
        if (root.left != null) {
            preOrder(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return arrayToTree(nums, 0, nums.length - 1);
    }

    public static TreeNode arrayToTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = arrayToTree(nums, left, mid - 1);
        root.right = arrayToTree(nums, mid + 1, right);

        return root;
    }
}
