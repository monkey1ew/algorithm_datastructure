package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 */
public class Solution_84 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permuteUnique(nums);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        backtrack(nums, set, list, isVisited);

        res.addAll(set);
//        System.out.println(res);
        return res;
    }

    public static void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> list, boolean[] isVisited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                if (isVisited[i]) {
                    continue;
                }
            }
            list.add(nums[i]);
            isVisited[i] = true;
            backtrack(nums, res, list, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}
