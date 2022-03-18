package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 807. 保持城市天际线
 */
public class Solution_807 {

    public static void main(String[] args) {

        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        maxIncreaseKeepingSkyline(grid);
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxRow = new int[grid.length];
        int[] maxCol = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
            }
        }
        for(int j = 0; j < grid[0].length; j++) {
            for(int i = 0; i < grid.length; i++) {
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return res;
    }
}
