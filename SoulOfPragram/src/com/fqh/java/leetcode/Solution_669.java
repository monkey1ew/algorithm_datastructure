package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 669. 修剪二叉搜索树
 */
public class Solution_669 {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode node1 = new TreeNode(0);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(1);
//        root.left = node1;
//        root.right = node2;
//        node1.right = node3;
//        node3.left = node4;
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        trimBST(root, 3, 4);
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        return dfs(root, low, high);
    }

    public static TreeNode dfs(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        // 如果当前节点值 < low (左子树的值则全部小于low)
        if(root.val < low) {
            // 看看右子树是否有小于low的
            return dfs(root.right, low, high);
        }
        // 如果当前节点值 > high (右子树的值则全部大于high)
        if(root.val > high) {
            // 看看左子树是否有大于high的
            return dfs(root.left, low, high);
        }
        // 将修剪的树连接起来
        root.left = dfs(root.left, low, high);
        root.right = dfs(root.right, low, high);
        return root;
    }
}
