package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1008. 前序遍历构造二叉搜索树
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 */
public class Solution_1008 {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println(root);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            add(root, new TreeNode(preorder[i]));
        }
        return root;
    }

    public static void add(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
            }
            add(root.left, node);
        }
        if (node.val > root.val) {
            if (root.right == null) {
                root.right = node;
            }
            add(root.right, node);
        }
    }
}
