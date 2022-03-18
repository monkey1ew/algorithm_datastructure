package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 47. 全排列 II
 */
public class Solution_47 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        boolean[] isVisited = new boolean[nums.length];
        backtrack(nums, list, set, isVisited);
        res.addAll(set);
        return res;
    }

    public static void backtrack(int[] nums, List<Integer> list, Set<List<Integer>> res, boolean[] isVisited)  {
        if (list.size() == nums.length) { //到达决策树的底层, 结束递归
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]) && isVisited[i]) {
                continue;
            }
            isVisited[i] = true; //i设置为已经访问
            list.add(nums[i]); //做选择
            backtrack(nums, list, res, isVisited); //递归
            list.remove(list.size() - 1); //回溯一次删除末尾元素
            isVisited[i] = false;               //回溯一次将i这个置为false
        }
    }
}
