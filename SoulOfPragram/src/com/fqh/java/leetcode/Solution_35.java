package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 35. 搜索插入位置
 */
public class Solution_35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int left, int right, int target) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return mid;
        }
        int midVal = nums[mid];
        if (target > midVal) {
            return search(nums, mid + 1, right, target);
        }else if (target < midVal) {
            return search(nums, left, mid - 1, target);
        }else {
            return mid;
        }
    }
}
