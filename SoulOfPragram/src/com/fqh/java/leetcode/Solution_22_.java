package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 22. 括号生成
 */
public class Solution_22_ {

    public static void main(String[] args) {

        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backtrack(n, n, sb, res);
//        System.out.println(res);
        return res;
    }

    public static void backtrack(int left, int right, StringBuilder sb, List<String> res) {
        if (left < 0 || right < 0) {
            return;
        }
        if (right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append("(");
        backtrack(left - 1, right, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        backtrack(left, right - 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
