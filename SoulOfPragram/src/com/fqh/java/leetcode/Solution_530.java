package com.fqh.java.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 530. 二叉搜索树的最小绝对差
 */
public class Solution_530 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(543);
        TreeNode node1 = new TreeNode(384);
        TreeNode node2 = new TreeNode(652);
        TreeNode node3 = new TreeNode(445);
        TreeNode node4 = new TreeNode(699);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);
        System.out.println(list);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                ans = Math.min(ans, list.get(i + 1) - list.get(i));
            }
        }
        return ans;
    }


    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
