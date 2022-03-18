package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 03. 数组中重复的数字 sort + 双指针 O(nlogn)
 */
public class Solution_03_ {

    public static void main(String[] args) {

        int[] nums = {7, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            if (nums[slow] == nums[fast]) {
                return nums[slow];
            }
            fast++;
            slow++;
        }
        return -1;
    }
}
