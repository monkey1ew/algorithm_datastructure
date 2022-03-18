package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 655. 输出二叉树
 */
public class Solution_655 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        System.out.println(printTree(root));
    }

    public static List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<String> list = new ArrayList<>();
            TreeNode node = queue.poll();
            if (node == null) {
                list.add("");
            } else {
                list.add(node.val + "");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
