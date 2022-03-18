package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1254. 统计封闭岛屿的数目
 */
public class Solution_1254 {
    static int grids = 0;
    static boolean flag = false;
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, isVisited);
                    if(!flag) {
                        count += 1;
                    }else {
                        flag = false;
                    }
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid, int row, int col, boolean[][] isVisited) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            flag = true;
            grids = 0;
            return;
        }
        if (isVisited[row][col]) {
            return;
        }
        if (grid[row][col] == 1) {
            return;
        }
        grid[row][col] = 1;
        isVisited[row][col] = true;
        dfs(grid, row - 1, col, isVisited);
        dfs(grid, row, col + 1, isVisited);
        dfs(grid, row + 1, col, isVisited);
        dfs(grid, row, col - 1, isVisited);
        isVisited[row][col] = false;
    }
}
