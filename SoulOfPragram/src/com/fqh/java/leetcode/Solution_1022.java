package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1022. 从根到叶的二进制数之和
 */
public class Solution_1022 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return -1;
        }
        String cur = "";
        List<String> list = new ArrayList<>();
        pathList(root, cur, list);
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s, 2);
        }

        return sum;
    }

    public static List<String> pathList(TreeNode root, String cur, List<String> list) {
        if (root == null) {
            return null;
        }
        cur += root.val;
        if (root.left == null && root.right == null) {
            list.add(cur);
        }
        if (root.left != null) {
            pathList(root.left, cur, list);
        }
        if (root.right != null) {
            pathList(root.right, cur, list);
        }
        return list;
    }
}
