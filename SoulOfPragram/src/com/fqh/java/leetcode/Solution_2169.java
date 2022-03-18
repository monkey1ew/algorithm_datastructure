package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2169. 得到 0 的操作数
 *
 * 输入：num1 = 2, num2 = 3
 * 输出：3
 * 解释：
 * - 操作 1 ：num1 = 2 ，num2 = 3 。由于 num1 < num2 ，num2 减 num1 得到 num1 = 2 ，num2 = 3 - 2 = 1 。
 * - 操作 2 ：num1 = 2 ，num2 = 1 。由于 num1 > num2 ，num1 减 num2 。
 * - 操作 3 ：num1 = 1 ，num2 = 1 。由于 num1 == num2 ，num1 减 num2 。
 * 此时 num1 = 0 ，num2 = 1 。由于 num1 == 0 ，不需要再执行任何操作。
 * 所以总操作数是 3 。
 */
public class Solution_2169 {

    public static void main(String[] args) {

        int num1 = 2;
        int num2 = 3;
        System.out.println(countOperations(num1, num2));
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;

        while (true) {
            if (num1 == 0 || num2 == 0) {
                break;
            }
            count++;
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        return count;
    }
}