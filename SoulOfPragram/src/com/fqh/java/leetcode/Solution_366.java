package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 366. 寻找二叉树的叶子节点
 * 输入: [1,2,3,4,5]
 *  
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 输出: [[4,5,3],[2],[1]]
 */
public class Solution_366 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        findLeaves(root);
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> son = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            TreeNode node = queue.poll();

            if (node.left != null && node.right != null) {
                list.add(node.val);
                stack.push(new ArrayList<>(list));
            }else {
                son.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        stack.push(son);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result.add(stack.pop());
        }
        System.out.println(result);
        return result;
    }
}
