package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1051. 高度检查器
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 */
public class Solution_1051 {

    public static void main(String[] args) {

        int[] heights = {1, 1, 4, 2, 1, 3};
        heightChecker(heights);
    }

    public static int heightChecker(int[] heights) {
        int[] ints = Arrays.copyOf(heights, heights.length);
        quickSort(ints, 0, ints.length - 1);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ints[i]) {
                count++;
            }
        }
        return count;

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[left + (right - left) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (l < right) {
            quickSort(arr, l, right);
        }
        if (r > left) {
            quickSort(arr, left, r);
        }
    }
}
