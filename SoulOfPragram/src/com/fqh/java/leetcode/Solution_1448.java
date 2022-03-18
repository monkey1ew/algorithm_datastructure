package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1448. 统计二叉树中好节点的数目
 */
public class Solution_1448 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(goodNodes(root));
    }


    public static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new ArrayList<>();
        countNodes(root, list);
        System.out.println(list);
        return list.size();
    }


    public static void countNodes(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        if (list.size() == 0) {
            list.add(root);
        }else if (root.val >= list.get(list.size() - 1).val) {
            list.add(root);
        }
        countNodes(root.left, list);

        countNodes(root.right, list);

    }
}
