package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_18 {

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(fourSum(nums, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int val = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                int v = val - nums[j];
//                for (int l = j + 1, k = nums.length - 1; l < nums.length; l++) {
//                    while (l < k && (nums[l] + nums[k] > v)) {
//                        k--;
//                    }
//                    if (l == k) {
//                        break;
//                    }
//                    if (nums[l] + nums[k] == v) {
//                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[l], nums[k]);
//                        resultList.add(list);
//                    }
//                }
            System.out.println(three(nums, i, val));
        }
        return null;
    }

    public static Set<List<Integer>> three(int[] nums, int f, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int val = target - nums[i];
            for (int j = i + 1, k = nums.length - 1; j < nums.length; j++) {
                while (j < k && (nums[j] + nums[k] > val)) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == val) {
                    List<Integer> list = Arrays.asList(nums[f], nums[i], nums[j], nums[k]);
                    set.add(list);
                }
            }
        }
        return set;
    }
}
