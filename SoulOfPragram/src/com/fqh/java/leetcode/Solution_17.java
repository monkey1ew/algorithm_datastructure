package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class Solution_17 {

    public static void main(String[] args) {

        String digits = "23";

        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {

        String[] mapping = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, digits, mapping);
        System.out.println(res);
        if (digits.length() == 0) {
            return res;
        }
        return res;
    }

    public static void backtrack(List<String> res, StringBuilder sb, String digits, String[] mapping) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < digits.length(); i++) {
            for (int j = i + 1; j < digits.length(); j++) {
                sb.append(mapping[digits.charAt(i)].charAt(i)).append(mapping[digits.charAt(j)].charAt(j));
                backtrack(res, sb, digits, mapping);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
