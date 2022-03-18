package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 747. 至少是其他数字两倍的最大数
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 *
 */
public class Solution_747 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == maxIndex) {
                continue;
            }else {
                if (2 * nums[i] > max) {
                    return -1;
                }
            }
        }
        return maxIndex;
    }
}
