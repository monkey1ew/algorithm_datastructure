package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2023. 连接后等于目标字符串的字符串对
 */
public class Solution_2023 {

    public static void main(String[] args) {
        String[] nums = {"777", "7", "77", "77"};
        String target= "7777";
        System.out.println(numOfPairs(nums, target));
    }
    //暴力匹配
    public static int numOfPairs(String[] nums, String target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target.equals(nums[i] + nums[j])) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
