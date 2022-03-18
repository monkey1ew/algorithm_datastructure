package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class Solution_34_ {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,5,9};
        int target = 3;
        searchRange(nums, target);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ints = binarySearch(nums, 0, nums.length - 1, target);
        Arrays.sort(ints);
        int[] res = new int[]{ints[0], ints[ints.length - 1]};
        return res;
    }

    public static int[] binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        int mid = left + (right - left) / 2;
        if (target > nums[mid]) {
           return binarySearch(nums, mid + 1, right, target);
        }else if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        }else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || nums[temp] != nums[mid]) {
                    break;
                }
                list.add(temp--);
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > right || nums[temp] != nums[mid]) {
                    break;
                }
                list.add(temp++);
            }
            return list.stream().mapToInt(Integer :: valueOf).toArray();
        }
    }
}
