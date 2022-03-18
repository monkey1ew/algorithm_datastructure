package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2016. 增量元素之间的最大差值
 */
public class Solution_2016 {

    public static void main(String[] args) {

        int[] nums = {7,1,5,4};
        System.out.println(maximumDifference(nums));
    }

    public static int maximumDifference(int[] nums) {
        int res = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] < nums[i + 1]) {
                minVal = Math.min(minVal, nums[i]);
                res = Math.max(res, nums[i + 1] - minVal);
            }
        }
        return res;
    }
}
