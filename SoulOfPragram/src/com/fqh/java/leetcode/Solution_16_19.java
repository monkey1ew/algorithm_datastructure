package com.fqh.java.leetcode;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 16.19. 水域大小
 */
public class Solution_16_19 {

    static int count;

    public static void main(String[] args) {

        int[][] land = new int[][] {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        pondSizes(land);
    }

    public static int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    dfs(land, i,j);
                    res.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void dfs(int[][] land, int row, int col) {
        if (row < 0 || row > land.length - 1 || col < 0 || col > land[0].length - 1) {
            return;
        }
        if (land[row][col] != 0) {
            return;
        }
        land[row][col] = 1;
        count += 1;
        dfs(land, row - 1, col);
        dfs(land, row - 1, col + 1);
        dfs(land, row, col + 1);
        dfs(land, row + 1, col + 1);
        dfs(land, row + 1, col);
        dfs(land, row + 1,col - 1);
        dfs(land, row, col - 1);
        dfs(land, row - 1, col - 1);
    }
}
