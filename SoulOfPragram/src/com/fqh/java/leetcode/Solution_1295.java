package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1295. 统计位数为偶数的数字
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数） 
 * 345 是 3 位数字（位数为奇数）  
 * 2 是 1 位数字（位数为奇数） 
 * 6 是 1 位数字 位数为奇数） 
 * 7896 是 4 位数字（位数为偶数）  
 * 因此只有 12 和 7896 是位数为偶数的数字
 */
public class Solution_1295 {

    public static void main(String[] args) {

        int[] nums = {437,315,322,431,686,264,442};
        findNumbers(nums);
    }

    public static int findNumbers(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((sb.append(nums[i]).length() % 2 == 0)) {
                count++;
            }
            sb.delete(0, sb.length());
        }
        System.out.println(count);
        return count;
    }
}
