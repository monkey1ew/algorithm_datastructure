package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 240. 搜索二维矩阵 II
 */
public class Solution_240 {

    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int l = matrix[0].length - 1;
        int r = 0;
        return dfs(matrix, r, l, target);

    }

    public static boolean dfs(int[][] matrix, int r, int l, int target) {
        if(r >= matrix.length || l < 0) {
            return false;
        }
        if(matrix[r][l] == target) {
            return true;
        }
        if(matrix[r][l] > target) {
            return dfs(matrix, r, l - 1, target);
        }
        if(matrix[r][l] < target) {
            return dfs(matrix, r + 1, l, target);
        }
        return false;
    }
}
