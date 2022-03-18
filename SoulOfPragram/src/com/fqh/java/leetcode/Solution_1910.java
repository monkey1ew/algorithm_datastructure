package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1910. 删除一个字符串中所有出现的给定子字符串
 */
public class Solution_1910 {

    public static void main(String[] args) {

        String s = "daabcbaabcbc";
        String part = "abc";

        removeOccurrences(s, part);
    }

    public static String removeOccurrences(String s, String part) {
        int[] next = kmpNext(part);
        int j = 0;
//        StringBuilder sb = new StringBuilder(s);

        while (s.length() >= part.length()) {

            for (int i = 0; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != part.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == part.charAt(j)) {
                    j++;
                }
                if (j == part.length()) {
                    s = s.substring(0, i - j + 1) + s.substring(i + 1);
                    break;
                }
            }
            j = 0;
            if (s.length() == part.length()) {
                if (!s.toString().equals(part)) {
                    break;
                }
            }
        }
        System.out.println(s);
        return s;
    }

    public static int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
