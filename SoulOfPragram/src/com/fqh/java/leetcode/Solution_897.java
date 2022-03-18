package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 897. 递增顺序搜索树
 */
public class Solution_897 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;

        System.out.println(increasingBST(root));
    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        infixOrder(root, list);
        TreeNode newRoot = new TreeNode(0);
        TreeNode cur = newRoot;
        for (int i = 0; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return newRoot.right;
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
