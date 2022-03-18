package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 617. 合并二叉树
 */
public class Solution_617 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        TreeNode root2 = new TreeNode(2);
        TreeNode nodei = new TreeNode(1);
        TreeNode nodej = new TreeNode(3);
        TreeNode nodek = new TreeNode(4);
        TreeNode nodem = new TreeNode(7);
        root2.left = nodei;
        root2.right = nodej;
        nodei.right = nodek;
        nodej.right = nodem;

        TreeNode node = mergeTrees(root1, root2);
        System.out.println(node);

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        return merge(root1, root2);
    }

    public static TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
        root.left = merge((root1 == null ? null : root1.left), (root2 == null ? null : root2.left));
        root.right = merge((root1 == null ? null : root1.right), (root2 == null ? null : root2.right));
        return root;
    }
}
