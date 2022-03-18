package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_250 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(countUnivalSubtrees(root));
    }

    public static int countUnivalSubtrees(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        preOrder(root, map);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet(); //取出map的键值对集合
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entrySet);	//将map的键值对集合加入到ArrayLsit
        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));
        if (root.val == list.get(0).getKey() && map.size() > 1) {
            return list.get(0).getValue() - 1;
        }
        return list.get(0).getValue();
    }

    public static void preOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        };
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preOrder(root.left, map);
        preOrder(root.right, map);
    }
}
