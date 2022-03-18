package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 795. 区间子数组个数
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 */
public class Solution_795 {

    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 3};
        numSubarrayBoundedMax(nums, 2, 3);
    }


    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, left, right, res, list);
        System.out.println(res);

        return -1;
    }

    public static void backtrack(int[] nums, int start, int left, int right, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
//            if (nums[i] < left || nums[i] > right) {
//                continue;
//            }
            list.add(nums[i]);
            backtrack(nums, i + 1, left, right, res, list);
            list.remove(list.size() - 1);
        }
    }
}
