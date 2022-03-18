package com.fqh.java.algorithm.dp;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 最长公共子序列
 */
public class Test03 {

    public static void main(String[] args) {
        String str1 = "acde";
        String str2 = "bacdae";
        System.out.println(longestCommonSubsequence(str1, str2));
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int[] link : dp) {
            System.out.println(Arrays.toString(link));
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    //在上一个最优情况+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    //取能让lcs最大的那一个
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("*******************************");
        for (int[] link : dp) {
            System.out.println(Arrays.toString(link));
        }
        return dp[m][n];
    }
}
