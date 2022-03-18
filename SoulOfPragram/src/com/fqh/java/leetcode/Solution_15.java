package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 15. 三数之和
 */
public class Solution_15 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(three(nums, 0));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = three(nums, 0);

        List<List<Integer>> resultList = new ArrayList<>();

        resultList.addAll(set);

        return resultList;
    }

    public static Set<List<Integer>> three(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            for (int j = i + 1, k = nums.length - 1; j < nums.length; j++) {
                while (j < k && (nums[j] + nums[k] > val)) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == val) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    set.add(list);
                }
            }
        }
        return set;
    }
}
