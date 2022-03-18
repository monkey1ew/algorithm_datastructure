package com.fqh.java.leetcode;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * @author 海盗狗
 * @version 1.0
 * 1967. 作为子字符串出现在单词中的字符串数目
 * 输入：patterns = ["a","abc","bc","d"], word = "abc"
 * 输出：3
 * 解释：
 * - "a" 是 "abc" 的子字符串。
 * - "abc" 是 "abc" 的子字符串。
 * - "bc" 是 "abc" 的子字符串。
 * - "d" 不是 "abc" 的子字符串。
 * patterns 中有 3 个字符串作为子字符串出现在 word 中。
 */
public class Solution_1967 {

    public static void main(String[] args) {
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        System.out.println(numOfStrings(patterns, word));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            int[] next = kmpNext(pattern);
            int j = 0;
            for (int i = 0; i < word.length(); i++) {
                while (j > 0 && word.charAt(i) != pattern.charAt(j)) {
                    j = next[j - 1];
                }
                if (word.charAt(i) == pattern.charAt(j)) {
                    j++;
                }
                if (j == pattern.length()) {
//                    return i - j + 1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        next[0] = 0;
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
