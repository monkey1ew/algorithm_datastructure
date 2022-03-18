package com.fqh.java.leetcode;

import sun.plugin2.applet.context.InitialJNLPExecutionContext;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 */
public class Solution_229 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(majorityElement(nums));
        
    }

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        hashMap.forEach((key, value) -> {
            if (value > nums.length / 3) {
                res.add(key);
            }
        });
        return res;

    }
}

class A {
    private static int i;
}