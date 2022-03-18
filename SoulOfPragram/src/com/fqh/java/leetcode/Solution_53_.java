package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 53. 最大子数组和
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class Solution_53_ {

    public static void main(String[] args) {
        int[] nusm = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nusm));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        //base case
        dp[0] = nums[0];

        //动态规划
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
