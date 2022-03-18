package com.fqh.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 217.存在重复元素
 */
public class Solution_217 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println("存在重复元素 : " + containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() < nums.length;
    }
}
