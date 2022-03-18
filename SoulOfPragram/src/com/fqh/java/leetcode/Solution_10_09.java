package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 10.09. 排序矩阵查找
 */
public class Solution_10_09 {

    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int l = matrix[0].length - 1;

        return dfs(matrix, target, r, l);
    }

    public static boolean dfs(int[][] matrix, int target, int r, int l) {
        if (r >= matrix.length || l < 0) {
            return false;
        }
        if (target > matrix[r][l]) {
            return dfs(matrix, target, r + 1, l);
        }
        if (target < matrix[r][l]) {
            return dfs(matrix, target, r, l - 1);
        }
        return true;
    }

}

