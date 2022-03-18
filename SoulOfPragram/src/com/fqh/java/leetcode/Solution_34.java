package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Solution_34 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, root, target);
        return res;
    }


    public static void backtrack(List<List<Integer>> res, List<Integer> list, TreeNode root, int target) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val - target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            backtrack(res, list, root.left, target - root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            backtrack(res, list, root.right, target - root.val);
            list.remove(list.size() - 1);
        }
    }
}
