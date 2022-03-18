package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1822. 数组元素积的符号
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * [9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24]
 */
public class Solution_1822 {

    public static void main(String[] args) {

        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                count++;
            }else if (nums[i] == 0) {
                return 0;
            }
        }
        return count % 2 == 0 ? 1 : - 1;
    }
}
