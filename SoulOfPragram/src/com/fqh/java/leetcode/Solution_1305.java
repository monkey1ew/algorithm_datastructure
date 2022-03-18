package com.fqh.java.leetcode;

import lombok.var;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1305. 两棵二叉搜索树中的所有元素
 */
public class Solution_1305 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(10);
        root1.left = node1;
        root1.right = node2;

        TreeNode root2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);
        root2.left = node3;
        root2.right = node4;
        node4.left = node5;
        node5.left = node6;

        getAllElements(root1, root2);
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        if (root1 == null && root2 == null) {
            return list;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root1);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.offer(root2);

        List<Integer> heplist = new ArrayList<>();

        while (!(queue1.isEmpty() && queue2.isEmpty())) {
            int n1 = queue1.size();
            int n2 = queue2.size();

            for (int i = 0; i < n1; i++) {
                TreeNode node = queue1.poll();
                if (node == null) {
                    break;
                }
                heplist.add(node.val);
                if (node.left != null) {
                    queue1.offer(node.left);
                }
                if (node.right != null) {
                    queue1.offer(node.right);
                }
            }

            for (int i = 0; i < n2; i++) {
                TreeNode node = queue2.poll();
                if (node == null) {
                    break;
                }
                heplist.add(node.val);
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
        }
        Collections.sort(heplist, ((o2, o1) -> (o2 - o1)));
        return heplist;
    }
}
