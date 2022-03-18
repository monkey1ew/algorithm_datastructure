package com.fqh.java.leetcode;

import javax.xml.soap.SOAPMessage;
import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 977. 有序数组的平方
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
public class Solution_977 {

    public static void main(String[] args) {
//        System.out.println(Math.pow(2, 3));
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.pow(Math.abs(nums[i]), 2));
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
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
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (l < right) {
            quickSort(nums, l, right);
        }
        if (left < r) {
            quickSort(nums, left, r);
        }
    }
}
