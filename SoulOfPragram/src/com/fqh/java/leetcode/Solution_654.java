package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 654. 最大二叉树
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 */
public class Solution_654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public static int findMaxIndex(int[] nums, int left, int right) {
        //找到数组中的最大值
        int maxIndex = left;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //找到数组中最大值和对应的索引
        int maxIndex = findMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, left, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, right);
        return root;
    }
}
