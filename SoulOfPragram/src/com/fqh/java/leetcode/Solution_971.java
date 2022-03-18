package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 971. 翻转二叉树以匹配先序遍历
 */
public class Solution_971 {

    public static void main(String[] args) {
        char c = 'a';

    }

    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        boolean flag = true;
        preOrder(root, list);
        for (int i = 0; i < voyage.length; i++) {
            if (list.get(i) != voyage[i]) {
                flag = false;
            }
        }
        if (!flag){
            bfs(root);
            list.add(root.val);
        }else {
            return new ArrayList<>();
        }

        return list;
    }

    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        bfs(root.left);
        bfs(root.right);
    }


    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
