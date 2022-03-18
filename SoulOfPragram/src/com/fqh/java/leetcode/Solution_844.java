package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 844. 比较含退格的字符串
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 0
 */
public class Solution_844 {

    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c1 : s.toCharArray()) {
            if (c1 == '#') {
                if (stack1.isEmpty()) {
                    continue;
                }
                stack1.pop();
            }else {
                stack1.push(c1);
            }
        }

        for (char c2 : t.toCharArray()) {
            if (c2 == '#') {
                if (stack2.isEmpty()) {
                    continue;
                }
                stack2.pop();
            }else {
                stack2.push(c2);
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }else {
            int n = stack1.size();
            for (int i = 0; i < n; i++) {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
