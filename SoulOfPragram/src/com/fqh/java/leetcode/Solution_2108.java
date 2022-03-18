package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2108. 找出数组中的第一个回文字符串
 * 输入：words = ["abc","car","ada","racecar","cool"]
 * 输出："ada"
 * 解释：第一个回文字符串是 "ada" 。
 * 注意，"racecar" 也是回文字符串，但它不是第一个。
 */
public class Solution_2108 {

    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }


    public static String firstPalindrome(String[] words) {
        for (String element : words) {
            StringBuffer reverse = new StringBuffer(element).reverse();
            if (reverse.toString().equals(element)) {
                return element;
            }
        }
        return "";
    }
}
