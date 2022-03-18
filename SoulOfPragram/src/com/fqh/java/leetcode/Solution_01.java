package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 1. 两数之和
 */
public class Solution_01 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                resultList.add(map.get(val));
                resultList.add(i);
            }
            map.put(nums[i], i);
        }
        int[] arr = new int[resultList.size()];
        int index = 0;
        for (int i : resultList) {
            arr[index++] = i;
        }
        return arr;
    }
}
