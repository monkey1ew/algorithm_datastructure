package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_463 {
    static int edges = 28;
    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {

        boolean[][] isVisitd = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, isVisitd);
                }
            }
        }
        System.out.println(edges);
        dfs(grid, 0, 1, isVisitd);
        return edges;
    }

    public static void dfs(int[][] grid, int row, int col, boolean[][] isVisited) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || isVisited[row][col]) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        if (grid[row][col] == 1) {
            edges -= 2;
            grid[row][col] = 0;
            isVisited[row][col] = true;
            dfs(grid, row - 1, col, isVisited);
            dfs(grid, row, col + 1, isVisited);
            dfs(grid, row + 1, col, isVisited);
            dfs(grid, row, col - 1, isVisited);
        }
    }
}
