package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *  输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 **/
public class Solution_26 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int len = removeDuplicates(nums);
        System.out.println(len);

    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 1;
        while (fast != n) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];

            }
            fast++;
        }
        return slow + 1;
    }
}
