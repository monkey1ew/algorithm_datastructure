package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class Solution_501 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        root.left = node3;
        root.right = node1;
        node1.left = node2;

        findMode(root);
    }

    public static int[] findMode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[] {root.val};
        }
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int ans = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        int fKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == ans) {
                fKey = entry.getKey();
                break;
            }
        }
        res.add(ans);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == fKey) {
                continue;
            }
            if (entry.getValue() == ans) {
                res.add(entry.getKey());
            }
        }
//        System.out.println(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        dfs(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.right, map);
    }
}
