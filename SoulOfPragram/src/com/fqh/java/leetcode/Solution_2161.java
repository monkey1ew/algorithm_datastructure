package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 2161. 根据给定数字划分数组
 * 输入：nums = [9,12,5,10,14,3,10], pivot = 10
 * 输出：[9,5,3,10,10,12,14]
 * 解释：
 * 元素 9 ，5 和 3 小于 pivot ，所以它们在数组的最左边。
 * 元素 12 和 14 大于 pivot ，所以它们在数组的最右边。
 * 小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [9, 5, 3] 和 [12, 14] ，它们在结果数组中的相对顺序需要保留。
 */
public class Solution_2161 {

    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        int[] ints = pivotArray(nums, pivot);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int k : nums) {
            if (k < pivot) {
                ans[j++] = k;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                ans[j++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                ans[j++] = num;
            }
        }
        return ans;
    }
}
