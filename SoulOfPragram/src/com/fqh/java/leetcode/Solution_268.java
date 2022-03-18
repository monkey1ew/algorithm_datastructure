package com.fqh.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 */
public class Solution_268 {

    public static void main(String[] args) {
//        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums = {3,0,1};
        int misVal = missingNumber(nums);
        System.out.println(misVal);
//        System.out.println(Arrays.toString(nums));
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length;

        int[] arr = new int[length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        System.out.println("hashset = " + hashSet);
        int missVal = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!hashSet.contains(arr[i])) {
                missVal = arr[i];
            }
        }

        return missVal;
    }
}
