package com.fqh.java.algorithm.dp;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 最长递增子序列 问题
 */
public class Test01 {
    static int max_len;
    public static void main(String[] args) {

        //最长递增子序列
        int[] nums = {1, 2, 5, 3, 4};


        System.out.println(maxLength(nums));
    }

    public static int maxLength(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
