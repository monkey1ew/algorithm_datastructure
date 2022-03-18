package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 107. 二叉树的层序遍历 II,
 * [
 *   [15,7],
 *   [9,20],
 *   [3]        先进后出， 栈
 * ]
 */
public class Solution_107 {

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

        List<List<Integer>> list = levelOrderBottom(root);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<ArrayList<Integer>> stack = new Stack<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (n >= 1) {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }else {
                        break;
                    }
                    arrayList.add(node.val);
                }
            }
            stack.push(arrayList);
        }
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            list.add(i, stack.pop());
        }
        return list;
    }
}
