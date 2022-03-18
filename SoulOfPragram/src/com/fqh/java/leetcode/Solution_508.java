package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 508. 出现次数最多的子树元素和
 */
public class Solution_508 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-3);

        root.left = node1;
        root.right = node2;

        int[] frequentTreeSum = findFrequentTreeSum(root);
        System.out.println(Arrays.toString(frequentTreeSum));
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                map.put(node.val, map.getOrDefault(node.val, 0) + 1);
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        System.out.println(map);
        return null;
    }
}
