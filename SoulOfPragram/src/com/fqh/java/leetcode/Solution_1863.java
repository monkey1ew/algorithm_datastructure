package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1863. 找出所有子集的异或总和再求和
 * 输入：nums = [1,3]
 * 输出：6
 * 解释：[1,3] 共有 4 个子集：
 * - 空子集的异或总和是 0 。
 * - [1] 的异或总和为 1 。
 * - [3] 的异或总和为 3 。
 * - [1,3] 的异或总和为 1 XOR 3 = 2 。
 * 0 + 1 + 3 + 2 = 6
 *。
 */
public class Solution_1863 {

    public static void main(String[] args) {

        int[] nums = {1, 3};
        System.out.println(subsetXORSum(nums));
    }


    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backtrack(nums, res, list, 0);
        int sum = 0;
        int ans = 0;
        for (List<Integer> link : res) {
            for (int i = 0; i < link.size(); i++) {
               ans ^= link.get(i);
            }
            sum += ans;
            ans = 0;
        }
//        System.out.println(sum);
        return sum;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
