package com.fqh.java.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 378. 有序矩阵中第 K 小的元素
 */
public class Solution_378 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        kthSmallest(matrix, k);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }
        int n = pq.size() - k;
        while (n-- != 0) {
            pq.poll();
        }
        return pq.poll();
    }
}
