package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1848. 到目标元素的最小距离
 */
public class Solution_1848 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;

        getMinDistance(nums, target, start);
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(Math.abs(i - start), res);
            }
        }
        System.out.println(res);
        return res;
    }
}
