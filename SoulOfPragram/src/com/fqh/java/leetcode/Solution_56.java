package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 */
public class Solution_56 {

    public static void main(String[] args) {

    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list = preOrder(root, list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int v = k - list.get(i);
            if (map.containsKey(v)) {
                return true;
            }
            map.put(list.get(i), i);
        }
        return false;
    }

    public static List<Integer> preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
        return list;
    }
}
