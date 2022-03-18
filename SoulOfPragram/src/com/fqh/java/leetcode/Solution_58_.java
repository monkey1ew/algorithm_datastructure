package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Solution_58_ {

    public static void main(String[] args) {

        String s = "abcdefg";
        int k = 2;
        reverseLeftWords(s, k);
    }

    public static String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            return s;
        }
//        String subStr = s.substring(0, n);
//        System.out.println(s.substring(n) + subStr);
        return s.substring(n) + s.substring(0, n);
    }
}
