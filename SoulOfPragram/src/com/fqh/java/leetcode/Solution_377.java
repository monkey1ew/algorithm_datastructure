package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 377. 组合总和 Ⅳ
 */
public class Solution_377 {

    public static void main(String[] args) {

        int[] nums = {4, 2, 1};
        int target = 32;
        combinationSum4(nums, target);
    }

    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, target, res, list);
        System.out.println(res);

        return res.size();
    }

    public static void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> list) {
        if (sum(list) == target) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum(list) > target) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, target, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
