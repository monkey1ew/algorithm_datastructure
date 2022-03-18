package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 周赛284:第一题
 */
public class Solution_6031 {

    public static void main(String[] args) {

        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9;
        int k = 1;
        System.out.println(findKDistantIndices(nums, key, k));
        Queue<Integer> queue = new PriorityQueue<>();
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                while (j < nums.length) {
                    if (Math.abs(j - i) <= k) {
                        res.add(j);
                    }
                    j++;
//                    j > i 并且 绝对值 > k就结束迭代
                    if (j > i && Math.abs(j - i) > k) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
