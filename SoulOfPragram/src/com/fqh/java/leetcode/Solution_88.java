package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 88. 合并两个有序数组
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 */
public class Solution_88 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[nums1.length];
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i >= n) {
                nums[i] = nums2[j++];
                continue;
            }
            nums[i] = nums1[i];
        }
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));

    }


    public static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = left + (right - left) / 2;
        int temp = 0;
        while (l < r) {
            while (nums[l] < nums[pivot]) {
                l += 1;
            }
            while (nums[r] > nums[pivot]) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            if (nums[l] == nums[pivot]) {
                r -= 1;
            }

            if (nums[r] == nums[pivot]) {
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
