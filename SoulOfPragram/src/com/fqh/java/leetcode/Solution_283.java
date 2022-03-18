package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 283. 移动零
 */
public class Solution_283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        for(int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
