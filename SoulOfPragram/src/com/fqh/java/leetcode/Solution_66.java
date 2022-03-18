package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 *66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 */
public class Solution_66 {

    public static void main(String[] args) {
        int[] arr = {9};
        int[] res = plusOne(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] plusOne(int[] digits) {
        int i = 0;
        int temp = 0;
        while (i < digits.length) {
            temp = digits[i];
            i++;
        }
        digits[i - 1] = temp + 1;
        return digits;
    }
}
