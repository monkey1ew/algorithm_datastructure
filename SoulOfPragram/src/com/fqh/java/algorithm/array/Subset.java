package com.fqh.java.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 子集
 */
public class Subset {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, res, list);

        return res;
    }

    public static void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        // 从start开始, 防止产生重复的子集
        for (int i = start; i < nums.length; i++) {
            // 选择
            list.add(nums[i]);
            // 递归回溯
            backtrack(nums, i + 1, res, list);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}
