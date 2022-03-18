package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 比奇堡海滩
 * @version
 * 150. 逆波兰表达式求值
 */
public class Solution_150 {

    public static void main(String[] args) {
        String[] strings ={"2", "1", "+", "3", "*"};
        System.out.println("res = " + evalRPN(strings));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1;
        int num2;
        for (String s : tokens) {
            if (s.equals("+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 + num2);
            }else if (s.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            }else if (s.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 * num2);
            }else if (s.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
