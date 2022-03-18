package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_1143 {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text2.length() + 1][text1.length() + 1];

        for (int[] link : dp) {
            System.out.println(Arrays.toString(link));
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
