package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 200. 岛屿数量
 */
public class Solution_200 {
    static int num;
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num += 1;
                }
            }
        }
        return  num;
    }

    public static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);

        }else {
            return;
        }
    }
}
