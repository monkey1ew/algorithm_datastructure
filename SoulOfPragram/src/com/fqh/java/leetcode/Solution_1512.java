package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1512. 好数对的数目
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 */
public class Solution_1512 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 3};
        numIdenticalPairs(nums);
    }


    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
