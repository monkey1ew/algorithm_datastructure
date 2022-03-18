package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 74. 搜索二维矩阵
 */
public class Solution_74 {

    public static void main(String[] args) {

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;
        return dfs(matrix, target, row, col);
    }

    public static boolean dfs(int[][] matrix, int target, int row, int col) {
        if (row >= matrix.length || col < 0) {
            return false;
        }
        if (matrix[row][col] == target) {
            return true;
        }
        if (target > matrix[row][col]) {
            return dfs(matrix, target, row + 1, col);
        }
        if (target < matrix[row][col]) {
            return dfs(matrix, target, row, col - 1);
        }
        return true;
    }
}
