package com.fqh.java.leetcode;

import lombok.var;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 102. 二叉树的层序遍历
 * BFS 广度优先搜索
 */
public class Solution_102 {

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
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            if (queue.size() >= 1) {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(list);
            }else {
                break;
            }
        }
        return res;
    }
}
