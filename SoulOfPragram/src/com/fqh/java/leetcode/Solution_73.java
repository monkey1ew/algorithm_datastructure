package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 73. 矩阵置零
 */
public class Solution_73 {

    public static void main(String[] args) {

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
//        记录应该将行置0还是列
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
