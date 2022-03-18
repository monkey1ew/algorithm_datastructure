package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 856. 括号的分数
 * 输入： "(())"
 * 输出： 2
 */
public class Solution_856 {

    public static void main(String[] args) {

    }

    public static int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == '(') {
                    stack.push(c);
                }else {
                    if (stack.peek() == ')') {
                        score += 1;
                    }
                }
            }else {
                stack.push(c);
            }
        }

        return -1;
    }
}
