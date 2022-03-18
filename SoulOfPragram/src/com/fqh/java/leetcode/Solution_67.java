package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 67. 二进制求和
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class Solution_67 {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String binary = addBinary(a, b);
        System.out.println(binary);
    }

    public static String addBinary(String a, String b) {
        int i = Integer.parseInt(a, 2);
        int j = Integer.parseInt(b, 2);
        return Integer.toBinaryString(i + j);
    }
}
