package com.fqh.java.leetcode;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 98. 验证二叉搜索树
 * 输入：root = [2,1,3]
 * 输出：true
 */
public class Solution_98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        infixOrder(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void infixOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        infixOrder(root.left, list);
        list.add(root.val);
        infixOrder(root.right, list);
    }
}
