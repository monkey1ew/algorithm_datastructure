package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 061. 和最小的 k 个数对
 */
public class Solution_61 {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        kSmallestPairs(nums1, nums2, k);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                res.add(new ArrayList<>(list));
            }
        }
        Queue<List<Integer>> pq = new PriorityQueue<>(
                ((o1, o2) -> ((o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)))));

        for (List<Integer> link : res) {
            pq.offer(link);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println("pq :" + pq);
        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }
}
