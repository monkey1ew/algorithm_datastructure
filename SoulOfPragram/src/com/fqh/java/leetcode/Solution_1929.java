package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1929. 数组串联
 * 输入：nums = [1,2,1]
 * 输出：[1,2,1,1,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 */
public class Solution_1929 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        getConcatenation(nums);
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        int index = 0;
        for (int i = 0; i < 2 * nums.length; i++) {
            if (index == nums.length) {
                index = 0;
            }
            ans[i] = nums[index++];
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
