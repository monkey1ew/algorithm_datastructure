package com.fqh.java.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 17.14. 最小K个数
 */
public class Solution_17_14 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        smallestK(arr, k);
    }

    public static int[] smallestK(int[] arr, int k) {
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        int[] ans = new int[k];
        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int index = 0;
        while (index < k) {
            ans[index++] = pq.poll();
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

}
