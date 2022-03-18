package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 973. 最接近原点的 K 个点
 */
public class Solution_973 {

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        kClosest(points, k);
    }

    public static int[][] kClosest(int[][] points, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] link : points) {
            int sum = (int) (Math.pow(2, link[0]) + Math.pow(2, link[1]));
            System.out.println(sum);
            map.put(sum, link);
        }

        Queue<Map.Entry<Integer, int[]>> pq = new PriorityQueue<>((o1, o2) -> (o2.getKey() - o1.getKey()));
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[pq.size()][2];
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().getValue();
        }
        for (int[] link : ans) {
            System.out.println(Arrays.toString(link));
        }
        return ans;
    }
}
