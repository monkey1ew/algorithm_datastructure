package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 */
public class Solution_53 {
    static List<TreeNode> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode treeNode = inorderSuccessor(root, node2);
        System.out.println(treeNode);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        infixOrder(root, list);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val == p.val && i + 1 < list.size()) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    public static void infixOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        infixOrder(root.left, list);
        list.add(root);
        infixOrder(root.right, list);
    }
}
