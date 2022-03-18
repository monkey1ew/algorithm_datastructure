package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1464. 数组中两元素的最大乘积
 */
public class Solution_1464 {

    public static void main(String[] args) {

        int[] nums = {1, 5, 4, 5};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = nums[left + (right - left) / 2];
        int temp = 0;
        while (l < r) {
            while (nums[l] < pivot) {
                l += 1;
            }
            while (nums[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if (nums[l] == pivot) {
                r -= 1;
            }
            if (nums[r] == pivot) {
                l -= 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (l < right) {
            quickSort(nums, l, right);
        }
        if (r > left) {
            quickSort(nums, left, r);
        }
    }
}
