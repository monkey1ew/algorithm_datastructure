package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 64. 最小路径和
 */
public class Solution_64 {

    public static void main(String[] args) {

        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
//        初始化base case: 第一行:只能从左边推, 第一列只能从上边推
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                dp[i][0] = grid[i][0];
            }else {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
        }
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                dp[0][j] = grid[0][j];
            }else {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                取从上面到当前路径 和 从左边到当前点的最小值
                dp[i][j] = Math.min(dp[i - 1][j]+ grid[i][j], dp[i][j - 1]+ grid[i][j]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
