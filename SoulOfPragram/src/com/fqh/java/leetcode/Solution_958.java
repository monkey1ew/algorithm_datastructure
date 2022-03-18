package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 958. 二叉树的完全性检验
 */
public class Solution_958 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        System.out.println(isCompleteTree(root));

    }

    public static boolean isCompleteTree(TreeNode root) {
       if (root == null) {
           return true;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       boolean flag = false;
       TreeNode node;
       while (!queue.isEmpty()) {
           node = queue.poll();
           if (node == null) { //遇见一个null
               flag = true; //标记
               continue;
           }
           if (flag) {  //前面有null, 当前不为null
               return false;
           }
           queue.offer(node.left);
           queue.offer(node.right);
       }
       return true;
    }
}
