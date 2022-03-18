package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 297. 二叉树的序列化与反序列化 [hard]
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class Solution_297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(serialize(root));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                stringBuilder.append(node.val + ",");
                if (node.left != null) {
                    queue.offer(node.left);
//                }else {
//                    stringBuilder.append(null + ",");
//                }
                    if (node.right != null) {
                        queue.offer(node.right);
//                }else {
//                    stringBuilder.append(null + ",");
//                }
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        return null;
    }
}
