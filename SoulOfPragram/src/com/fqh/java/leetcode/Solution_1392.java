package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1392. 最长快乐前缀
 * 输入：s = "level"
 * 输出："l"
 * 解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", "evel"）。最长的既是前缀也是后缀的字符串是 "l" 。
 */
public class Solution_1392 {

    public static void main(String[] args) {
        String s = "bba";
        System.out.println(longestPrefix(s));
    }

    public static String longestPrefix(String s) {
        if (s.length() == 1) {
            return "";
        }
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
        System.out.println(Arrays.toString(next));
        Arrays.sort(next);
        System.out.println(Arrays.toString(next));
        return s.substring(0, next[next.length - 1]);
    }
}
