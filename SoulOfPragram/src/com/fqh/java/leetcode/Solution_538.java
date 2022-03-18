package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 538. 把二叉搜索树转换为累加树
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
public class Solution_538 {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        convertBST(root);

    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convert(root);
        return root;
    }

    public static void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            convert(root.right);
        }
        sum += root.val;
        root.val = sum;
        if (root.left != null) {
            convert(root.left);
        }
    }
}
