package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 100.相同的树
 */
public class Solution_100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode pNode1 = new TreeNode(2);
        TreeNode pNode2 = new TreeNode(3);
        p.left = pNode1;
        p.right = pNode2;

        TreeNode q = new TreeNode(1);
        TreeNode qNode1 = new TreeNode(2);
        TreeNode qNode2 = new TreeNode(3);
        q.left = qNode1;
        q.right = qNode2;

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
