package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 */
public class Solution_32_ {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        List<List<Integer>> list = levelOrder(root);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            List<Integer> arrayList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                if (depth % 2 == 0) {
                    stack.push(node.val);
                }else {
                    arrayList.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            while (!stack.isEmpty()) {
                arrayList.add(stack.pop());
            }
            list.add(arrayList);
            depth++;

        }
        return list;
    }
}
