package com.fqh.java.leetcode;

import lombok.val;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author 海盗狗
 * @version 1.0
 * 2022. 将一维数组转变成二维数组
 */
public class Solution_2022 {

    public static void main(String[] args) {

        int[] original = {1, 2, 3, 4};
        int m = 2;
        int n = 2;
        construct2DArray(original, m, n);


    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[index++];
            }
        }
//        for (int[] link : ans) {
//            System.out.println(Arrays.toString(link));
//        }

        return ans;
    }

}
