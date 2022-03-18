package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 653. 两数之和 IV - 输入 BST
 */
public class Solution_653 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        System.out.println(findTarget(root, 9));
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        treeToArray(root, list);
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = k - arr[i];
            if (map.containsKey(val)) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }


    public static void treeToArray(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        treeToArray(root.left, list);
        list.add(root.val);
        treeToArray(root.right, list);
    }
}
