package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 04. 二维数组中的查找
 */
public class Solution_04_ {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 1;
        System.out.println(findNumberIn2DArray(matrix, target));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int l = matrix[0].length - 1;
        int r = 0;
        // 从右上角出发
        return dfs(matrix, target, r, l);
    }

    public static boolean dfs(int[][] matrix, int target, int r, int l) {
        if (r >= matrix.length || l < 0) {
            return false;
        }
        if (target == matrix[r][l]) {
            return true;
        }
        if (target < matrix[r][l]) {
            return dfs(matrix, target, r, l - 1);
        }
        if (target > matrix[r][l]) {
            return dfs(matrix, target, r + 1, l);
        }
        return false;
    }
}
