package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 136.只出现一次的数字
 */
public class Solution_136 {

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 4, 2};
        int res = singleNumber(nums);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
