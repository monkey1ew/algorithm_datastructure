package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 01.08. 零矩阵
 */
public class Solution_08_1 {
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setZeroes(matrix);
    }


    public static void setZeroes(int[][] matrix) {

        List<Integer> needed = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    needed.add(i);
                    needed.add(j);
                }
            }
        }
        int rowOrCol = 0;
        for (int i : needed) {
            if (rowOrCol % 2 == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }else {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
            rowOrCol += 1;
        }
    }
}
