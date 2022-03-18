package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_6017 {

    public static void main(String[] args) {

        int[] nums = {1, 4, 25, 10, 25};
        int k = 2;
        System.out.println(minimalKSum(nums, k));
    }

    public static long minimalKSum(int[] nums, int k) {

        Arrays.sort(nums);
        long res = 0L;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int count = 0;
        for (int i = 1; i < k + nums[nums.length - 1]; ) {
            if (count == k) {
                break;
            }
            if (list.contains(i)) {
                i++;
                continue;
            }
            count++;
            res += i;
            i++;
        }
        return res;

    }
}
