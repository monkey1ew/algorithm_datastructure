package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 222. 完全二叉树的节点个数
 */
public class Solution_222 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        int count = countNodes(root);
        System.out.println(count);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = 0;
        int rh = 0;
        TreeNode left = root;
        TreeNode right = root;

        while (left != null) {
            left = left.left;
            lh++;
        }
        while (right != null) {
            right = right.right;
            rh++;
        }
        if (rh == lh) { //说明是满二叉树, n^2 - 1
            return (int) Math.pow(2, lh) - 1;
        }
        //说明不是按普通二叉树处理
        return 1 + countNodes(root.left) + countNodes(root.right);
        //        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int num = 0;
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                if (node == null) {
//                    break;
//                }
//                num += 1;
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return num;
    }
}
