package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 695. 岛屿的最大面积
 */
public class Solution_695 {
    static int area;
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int k = dfs(grid, i, j, isVisited);
                    res = Math.max(res, k);
                    area = 0;
                }
            }
        }
        return res;
    }

    public static int dfs(int[][] grid, int row, int col, boolean[][] isVisited) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || isVisited[row][col]) {
            return area;
        }
        if (grid[row][col] == 0) {
            return area;
        }
        if (grid[row][col] == 1) {
            area += 1;
            isVisited[row][col] = true;
            grid[row][col] = 0;
            dfs(grid, row - 1, col, isVisited);
            dfs(grid, row, col + 1, isVisited);
            dfs(grid, row + 1, col, isVisited);
            dfs(grid, row, col - 1, isVisited);
            isVisited[row][col] = false;
        }
        return area;
    }
}
