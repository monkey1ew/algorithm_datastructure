package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 449. 序列化和反序列化二叉搜索树
 */
public class Solution_449 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        node1.right = node3;
        root.left = node1;
        root.right = node2;

        String data = serialize(root);
        System.out.println(deserialize(data));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        String NULL = "#";
        String SEP = ",";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                stringBuilder.append(NULL).append(SEP);
                continue;
            }
            stringBuilder.append(node.val).append(SEP);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);

        for (int i = 1; i < split.length; ) {
            TreeNode node = queue.poll();
            String left = split[i++];
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }else {
                node.left = null;
            }
            String right = split[i++];
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }else {
                node.right = null;
            }
        }
        return root;
    }
}
