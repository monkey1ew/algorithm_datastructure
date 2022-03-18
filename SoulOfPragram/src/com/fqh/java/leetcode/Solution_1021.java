package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 1021. 删除最外层的括号
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 */
public class Solution_1021 {

    public static void main(String[] args) {

        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }


    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            }else {
                if (c == stack.peek()) {
                    stack.pop();
                    stack.push(c);
                }else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = stack.size();

        System.out.println(stack);
        for (int i = 0; i < n; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

