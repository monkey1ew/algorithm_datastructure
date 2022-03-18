package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_1214 {

    public static void main(String[] args) {

    }

    public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        preOrder(root1, nums1);
        preOrder(root2, nums2);

        Map<Integer, Integer> map = new HashMap<>();

        return false;
    }

    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
