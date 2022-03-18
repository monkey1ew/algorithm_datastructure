package com.fqh.java.algorithm.dp;

/**
 * @author 海盗狗
 * @version 1.0
 * 最大子数组的和
 */
public class Test02 {

    public static void main(String[] args) {
        int[] nums = {-3, 4, -1, 2, -6, 4};
        System.out.println("最大子数组和 : " + maxSubArraySum(nums));
    }

    public static int maxSubArraySum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //取 自成一派 和 跟前面的一派 的最大值
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
