package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 55.跳跃游戏
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class Solution_55_ {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);
            if(farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}
