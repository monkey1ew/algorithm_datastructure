package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 01.01. 判定字符是否唯一
 * 输入: s = "leetcode"
 * 输出: false
 */
public class Solution_01_ {

    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
