package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 20. 有效的括号
 */
public class Solution_20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    if (c == ')') {
                        Character ch = stack.pop();
                        if (ch != '(') {
                            return false;
                        }
                    }else if (c == ']') {
                        Character ch = stack.pop();
                        if (ch != '[') {
                            return false;
                        }
                    }else if (c == '}') {
                        Character ch = stack.pop();
                        if (ch != '{') {
                            return false;
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
