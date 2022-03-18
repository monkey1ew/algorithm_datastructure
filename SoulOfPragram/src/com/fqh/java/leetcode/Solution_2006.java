package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2006. 差的绝对值为 K 的数对数目
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 */
public class Solution_2006 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 1};
        int k = 1;
        countKDifference(nums, k);
    }

    public static int countKDifference(int[] nums, int k) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
//        System.out.println(res);
        return res;
    }
}
