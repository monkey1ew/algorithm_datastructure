package com.fqh.java.leetcode;

import sun.nio.cs.ext.IBM037;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 079. 所有子集
 */
public class Solution_79_ {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, res, list);
        System.out.println(res);

        return res;
    }

    public static void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
