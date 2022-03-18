package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 38. 字符串的排列
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Solution_38 {

    public static void main(String[] args) {
        String s = "abc";
        permutation(s);
    }

    public static String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean[] isVisited = new boolean[chars.length];
        backtrack(chars,res , sb, isVisited);
        Set<String> set = new HashSet<>();
        set.addAll(res);
        String[] ans = new String[set.size()];
        int index = 0;

        for (String str : set) {
            ans[index++] = str;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void backtrack(char[] chars, List<String> res, StringBuilder sb, boolean[] isVisited) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            sb.append(chars[i]);
            backtrack(chars, res, sb, isVisited);
            isVisited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
