package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 08.08. 有重复字符串的排列组合
 */
public class Solution_08_08 {

    public static void main(String[] args) {

        String S = "ab";
        System.out.println(Arrays.toString(permutation(S)));
    }

    public static String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] isVisited = new boolean[S.length()];
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(chars, isVisited, res, sb);
        Set<String> set = new HashSet<>();
        set.addAll(res);
        String[] ans = new String[set.size()];
        int index = 0;
        for (String str : set) {
            ans[index++] = str;
        }
        return ans;
    }

    public static void backtrack(char[] chars, boolean[] isVisited, List<String> res, StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisited[i]) {
                    continue;
            }
            sb.append(chars[i]);
            isVisited[i] = true;
            backtrack(chars, isVisited, res, sb);
            isVisited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
