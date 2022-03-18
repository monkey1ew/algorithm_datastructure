package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1609. 奇偶树
 */
public class Solution_1609 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(6);
        TreeNode node9 = new TreeNode(2);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node5.right = node9;

        boolean evenOddTree = isEvenOddTree(root);
        System.out.println(evenOddTree);

    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                if (depth % 2 == 0 && node.val % 2 != 0) {
                    list.add(node.val);
                } else if (depth % 2 != 0 && node.val % 2 == 0) {
                    list.add(node.val);
                } else {
                    return false;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            map.put(depth, list);
            depth++;
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey() > 0) {
                if (entry.getKey() % 2 == 0) {
                    int[] arr = new int[entry.getValue().size()];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = entry.getValue().get(i);
                    }
                    System.out.println(Arrays.toString(arr));
                    for (int i = 0; i < arr.length; i++) {
                        if (i + 1 < arr.length && arr[i] >= arr[i + 1]) {
                            return false;
                        }
                    }

                } else {
                    int[] arr = new int[entry.getValue().size()];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = entry.getValue().get(i);
                    }
                    System.out.println(Arrays.toString(arr));
                    for (int i = 0; i < arr.length; i++) {
                        if (i + 1 < arr.length && arr[i] <= arr[i + 1]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
