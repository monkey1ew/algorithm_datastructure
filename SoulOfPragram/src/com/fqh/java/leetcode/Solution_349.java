package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * LeetCode----349: 两个数组的交集
 */
public class Solution_349 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4}; //[4, 9]
        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i : nums1) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            res[index++] = i;
        }
        return res;
    }
}
