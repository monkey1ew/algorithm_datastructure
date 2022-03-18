package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 459. 重复的子字符串
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Solution_459 {

    public static void main(String[] args) {
        String s = "abcancsada";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int[] next = kmpNext(s);
        System.out.println(Arrays.toString(next));
        int len = s.length();
        if (next[len - 1] != 1 && len % (len - (next[len - 1] + 1)) == 0) {
            return true;
        }
        return false;
    }

    public static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
