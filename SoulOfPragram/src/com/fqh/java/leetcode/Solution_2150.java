package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 2150. 找出数组中的所有孤独数字
 */
public class Solution_2150 {

    public static void main(String[] args) {

        int[] nums = {10, 6, 5, 8};
        findLonely(nums);
    }

    public static List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + 1) || map.containsKey(nums[i] - 1) || map.get(nums[i]) > 2) {
                continue;
            }
            res.add(nums[i]);
        }
        return res;
    }
}
