package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 62. 不同路径
 * 输入：m = 3, n = 7
 * 输出：28
 */
public class Solution_62 {

    public static void main(String[] args) {

        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
//        定义dp数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                第一行和第一列的元素只有一种走法
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else {
//                    当前元素走法 = 当前元素的上面元素走法 + 当前元素的左边元素走法
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
