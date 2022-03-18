package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1135. 最低成本联通所有城市 Prim
 */
public class Solution_1135_ {

    public static void main(String[] args) {
        int[][] connections = new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        System.out.println(minimumCost(3, connections));
    }

    public static int minimumCost(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int[][] helper = helper(connections);

        int sum = 0;
        int h2 = -1;
        int weight = Integer.MAX_VALUE;
        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        for (int k = 1; k < helper.length; k++) {
            for (int i = 0; i < helper.length; i++) {
                if (isVisited[i]) {
                    for (int j = 0; j < helper.length; j++) {
                        if (!isVisited[j] && helper[i][j] < weight) {
                            weight = helper[i][j];
                            h2 = j;
                        }
                    }
                }
            }
            System.out.println(weight);
            isVisited[h2] = true;
            weight = Integer.MAX_VALUE;
        }

        return -1;
    }

    public static int[][] helper(int[][] connections) {
        int[][] ints = new int[connections.length][connections.length];
        for (int[] link : connections) {
            int p = link[0];
            int q = link[1];
            int weight = link[2];
            ints[p - 1][q - 1] = weight;
            ints[q - 1][p - 1] =  weight;
        }

        for (int[] link : ints) {
            System.out.println(Arrays.toString(link));
        }
        return ints;
    }
}
