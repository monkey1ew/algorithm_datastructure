package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2057. 值相等的最小索引
 */
public class Solution_2057 {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 1};
        smallestEqual(nums);
    }

    public static int smallestEqual(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i % 10 == nums[i]) {
                res = Math.min(res, i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
