package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 112. 路径总和
 */
public class Solution_112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.right = node6;
        node3.left = node5;
        node2.left = node4;

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return false;
        }
        List<Integer> helper = helper(root, 0, list);
        for(int i : helper) {
            if (i == targetSum) {
                return true;
            }
        }
        return false;
    }


    public static List<Integer> helper(TreeNode root, int temp, List<Integer> list) {
        if (root == null) {
            return null;
        }
        temp += root.val;
        if (root.left == null && root.right == null) {
            list.add(temp);
        }
        if (root.left != null) {
            helper(root.left, temp, list);
        }
        if (root.right != null) {
            helper(root.right, temp, list);
        }
        return list;
    }
}
