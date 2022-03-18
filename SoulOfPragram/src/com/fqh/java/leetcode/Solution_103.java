package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution_103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(16);

        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(4);


        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;

        List<List<Integer>> list = zigzagLevelOrder(root);
        System.out.println(list);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<Integer> stack = new Stack<>();


        while (!queue.isEmpty()) {
            List<Integer> arrayList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (depth % 2 != 0) {
                        arrayList.add(node.val);
                    } else {
                        stack.push(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            depth++;
            if (!stack.isEmpty()) {
                int size = stack.size();
                for (int j = 0; j < size; j++) {
                    arrayList.add(stack.pop());
                }
                list.add(arrayList);
            }else {
                list.add(arrayList);
            }
        }
        return list;
    }
}
