package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 814. 二叉树剪枝
 */
public class Solution_814 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        TreeNode root2 = pruneTree(root);
        System.out.println(root2.right.left);
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public static TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        //遇到了0并且是子树就返回null
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
