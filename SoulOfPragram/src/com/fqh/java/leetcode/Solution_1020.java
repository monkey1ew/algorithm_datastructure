package com.fqh.java.leetcode;

import com.sun.corba.se.impl.legacy.connection.USLPort;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1020.飞地数量
 */
public class Solution_1020 {
    static boolean flag = false;
    static int num = 0;
    public static void main(String[] args) {

        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, n - 1);
            dfs(grid, i, 0);
        }

        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    count += num;
                    num = 0;
                }
            }
        }
        return count;
    }


    public static void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row > grid.length || col < 0 || col > grid[0].length) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        num += 1;
        dfs(grid, row - 1,col);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
    }
}

