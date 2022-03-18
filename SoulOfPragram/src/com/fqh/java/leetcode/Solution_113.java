package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 113. 路径总和 II
 */
public class Solution_113 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(root, resultList, list, targetSum);
        return resultList;
    }

    public static void dfs(TreeNode root, List<List<Integer>> resultList, List<Integer> list, int target) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        //将节点值加入到list
        if (root.left == null && root.right == null) { //叶子节点
            if (target - root.val == 0) {   //如果target - 节点的值 = 0; 说明是一条路
                resultList.add(new ArrayList<>(list)); //就new一个list放入list
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left, resultList, list, target - root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, resultList, list, target - root.val);
            list.remove(list.size() - 1);
        }
    }
}
