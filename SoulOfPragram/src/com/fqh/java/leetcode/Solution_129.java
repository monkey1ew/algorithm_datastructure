package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 129. 求根节点到叶节点数字之和
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 */
public class Solution_129 {
    static int res = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        int sumNumbers = sumNumbers(root);
        System.out.println(sumNumbers);
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int num) {
        if (root == null) {
            return -1;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += num;  //遍历到叶节点，将number加入res中
        }
        dfs(root.left, num);
        dfs(root.right, num);
        return res;
    }
}
