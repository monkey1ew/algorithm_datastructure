package com.fqh.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 006. 排序数组中两个数字之和
 */
public class Solution_06_ {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 10};
        int target = 8;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int v = target - numbers[i];
            if (map.containsKey(v)) {
                int res1 = map.get(v);
                return new int[]{res1, i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}
