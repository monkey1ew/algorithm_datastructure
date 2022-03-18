package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Solution_53_I {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return -1;
        }
        if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, right, target);
        }else if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        }else {
            int temp = mid - 1;
            List<Integer> list = new ArrayList<>();
            while (true) {
                if (temp < 0 || nums[temp] != target) {
                    break;
                }
                list.add(temp--);
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > right || nums[temp] != target) {
                    break;
                }
                list.add(temp++);
            }
            return list.size();
        }
    }
}
