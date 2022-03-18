package com.fqh.java.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 海盗狗
 * @version 1.0
 * 90. 子集 II
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Solution_90 {

    public static void main(String[] args) {

        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums); //将数组排序，重复元素排在一起
        backtrack(nums, res, list, 0);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
//            重复元素剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
