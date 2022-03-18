package com.fqh.java.leetcode;

import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 *  606. 根据二叉树创建字符串
 *  输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 */
public class Solution_606 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        tree2str(root);

    }

    public static String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        backtrack(root, sb);
        System.out.println(sb);

        return sb.toString();
    }

    public static void backtrack(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(")");
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
        }else {
            sb.append(root.val + "(");
        }
        backtrack(root.left, sb);
        backtrack(root.right, sb);
    }
}
