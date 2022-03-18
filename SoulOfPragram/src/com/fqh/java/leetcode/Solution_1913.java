package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1913. 两个数对之间的最大乘积差
 * 输入：nums = [5,6,2,7,4]
 * 输出：34
 * 解释：可以选出下标为 1 和 3 的元素构成第一个数对 (6, 7) 以及下标 2 和 4 构成第二个数对 (2, 4)
 * 乘积差是 (6 * 7) - (2 * 4) = 34
 */
public class Solution_1913 {

    public static void main(String[] args) {

        int[] nums = {5, 6, 2, 7, 4};
        System.out.println(maxProductDifference(nums));
    }

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}
