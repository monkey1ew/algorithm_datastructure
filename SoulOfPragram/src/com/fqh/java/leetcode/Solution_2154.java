package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 2154. 将找到的值乘以 2
 */
public class Solution_2154 {

    public static void main(String[] args) {

        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        System.out.println(findFinalValue(nums, original));
    }

    public static int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int ans = original;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ans) {
                ans *= 2;
            }
        }
        return ans;
    }
}
