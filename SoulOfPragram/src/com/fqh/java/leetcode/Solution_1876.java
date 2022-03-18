package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1876. 长度为三且各字符不同的子字符串
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz"
 *
 */
public class Solution_1876 {

    public static void main(String[] args) {
        String s = "xyzzaz";
        countGoodSubstrings(s);
    }

    public static int countGoodSubstrings(String s) {
        List<String> list = new ArrayList<>();
        int j = 3;
        for (int i = 0; j <= s.length(); i++) {
            list.add(s.substring(i, j++));
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (String pattern : list) {
            for (char c : pattern.toCharArray()) {
                set.add(c);
            }
            if (set.size() == pattern.length()) {
                int[] next = kmpNext(pattern);
                int k = 0;
                for (int i = 0; i < s.length(); i++) {
                    while (k > 0 && s.charAt(i) != pattern.charAt(k)) {
                        k = next[k - 1];
                    }
                    if (s.charAt(i) == pattern.charAt(k)) {
                        k++;
                    }
                    if (k == pattern.length()) {
                        count++;
                        break;
                    }
                }
            }
            set.clear();
        }
//        System.out.println(count);
        return count;
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
