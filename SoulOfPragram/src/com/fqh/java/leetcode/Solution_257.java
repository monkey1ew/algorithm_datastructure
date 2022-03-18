package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 257. 二叉树的所有路径
 */
public class Solution_257 {
    static List<String> resultList = new ArrayList<>();
    static String path;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        setPath(root, "", list);
        return list;
    }

    public static void setPath(TreeNode root, String cur, List<String> list) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (root.left == null && root.right == null) {
            list.add(cur);
        }
        if (root.left != null) {
            setPath(root.left, cur + "->", list);
        }
        if (root.right != null) {
            setPath(root.right, cur + "->", list);
        }
    }
}
