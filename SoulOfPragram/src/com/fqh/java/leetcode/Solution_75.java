package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 75. 颜色分类
 *  输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Solution_75 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = nums[(left + right) / 2];
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
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(nums, left, r);
        }
        if (right > l) {
            quickSort(nums, l, right);
        }
    }
}
