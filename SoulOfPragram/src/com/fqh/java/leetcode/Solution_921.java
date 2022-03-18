package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 921. 使括号有效的最少添加
 * 输入："((("
 * 输出：3
 */
public class Solution_921 {

    public static void main(String[] args) {

        String s = "()";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int need = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        need--;
                    }else {
                        stack.push(c);
                        need++;
                    }
                }else {
                    stack.push(c);
                    need++;
                }
            }else {
                stack.push(c);
                need++;
            }
        }
        return need;
    }
}
