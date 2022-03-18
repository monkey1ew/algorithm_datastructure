package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 1190. 反转每对括号间的子串
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
 */
public class Solution_1190 {

    public static void main(String[] args) {

        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty()) {
                if (c == ')') {
                    while (!stack1.isEmpty()) {
                        Character pop = stack1.pop();
                        if (pop == '(') {
                            break;
                        }else {
                            stack2.push(pop);
                        }
                    }
                }else if (c == '(') {
                    stack2.push(stack1.pop());
                }else {
                    stack1.push(c);
                }
            }else {
                stack1.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = stack2.size();
        for (int i = 0; i < n; i++) {
            sb.append(stack2.pop());
        }
        return sb.toString();
    }
}
