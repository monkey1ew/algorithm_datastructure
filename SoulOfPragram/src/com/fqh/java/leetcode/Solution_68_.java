package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 068. 查找插入位置
 */
public class Solution_68_ {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return mid;
        }

        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, right);
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return mid;
        }
    }
}
