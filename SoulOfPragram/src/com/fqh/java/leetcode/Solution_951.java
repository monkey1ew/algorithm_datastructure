package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 951. 翻转等价二叉树
 */
public class Solution_951 {

    public static void main(String[] args) {

    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {

        return dfs(root1, root2);
    }

    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.left != q.right) {
            return false;
        }

        return (dfs(p.left, q.right) && dfs(p.right, q.left)) || (dfs(p.right, q.right) && dfs(p.left, q.left));
    }
}
