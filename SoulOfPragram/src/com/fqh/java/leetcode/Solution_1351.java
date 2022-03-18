package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1351. 统计有序矩阵中的负数
 */
public class Solution_1351 {

    public static void main(String[] args) {

    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
