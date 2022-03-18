package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution_27 {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3,7,9};
        int res = removeElement(nums, 3);
        System.out.println(res);
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                i++;
            }else {
                nums[index++] = nums[i++];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

}
