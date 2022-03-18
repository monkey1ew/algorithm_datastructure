package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 230. 二叉搜索树中第K小的元素
 */
public class Solution_230 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        node1.right = node3;
        root.right = node2;

        System.out.println(kthSmallest(root, 2));
    }

    public static int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        infixOrder(root);
        System.out.println(list);
        return list.get(k - 1);
    }

    public static void infixOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        infixOrder(root.left);
        list.add(root.val);
        infixOrder(root.right);
    }
}
