package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 面试题 16.01. 交换数字
 */
public class Solution_16_ {

    public static void main(String[] args) {
        int[] numbers = {1, 2};
        System.out.println(1 ^ 2);
        System.out.println(3 ^ 2);
        System.out.println(3 ^ 1);

        System.out.println(Arrays.toString(swapNumbers(numbers)));
    }


    public static int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
