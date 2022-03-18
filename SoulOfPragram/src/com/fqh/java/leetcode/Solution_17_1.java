package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class Solution_17_1 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(printNumbers(n)));
    }

    public static int[] printNumbers(int n) {

        int num = (int) Math.pow(10, n) - 1;
        int[] ans = new int[num];
        for (int i = 0; i < num; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
