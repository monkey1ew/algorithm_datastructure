package com.fqh.java.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1161. 最大层内元素和
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 */
public class Solution_1161 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(-8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        int maxLevelSum = maxLevelSum(root);
        System.out.println(maxLevelSum);
    }

    public static int maxLevelSum(TreeNode root) {
        if (root == null) {
            throw new RuntimeException("root is null");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        Map<String, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            map.put(depth + "", sum);
//            ans = Math.max(ans, sum);
            depth++;
        }


        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));
        return Integer.parseInt(list.get(0).getKey());
    }
}
