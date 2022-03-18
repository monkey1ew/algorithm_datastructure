package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 71. 简化路径
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 */
public class Solution_71 {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        boolean[] popLimit = new boolean[2];
        int index = 0;
        for (int i = 0; i < path.length(); i++) {
            if (!stack.isEmpty()) {
                if (path.charAt(i) == '/') {
                    if (stack.peek() == '/') {
                        stack.pop();
                        stack.push(path.charAt(i));
                        continue;
                    }
                    if (stack.peek() == '.') {
                        stack.pop();
                        continue;
                    }
                    if (i == path.length() - 1) {
                        continue;
                    }
                }else if (path.charAt(i) == '.') {
                    if (stack.peek() == '.') {
                        while (!(popLimit[0] && popLimit[1])) {
                            if (!stack.isEmpty()) {
                                Character pop = stack.pop();
                                if (pop == '/') {
                                    popLimit[index++] = true;
                                }
                            }else {
                                break;
                            }
                        }
                        popLimit[0] = false;
                        popLimit[1] = false;
                        index = 0;
                        continue;
                    }
                }
                stack.push(path.charAt(i));
            }else {
                stack.push(path.charAt(i));
            }
        }
//        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        if (stack.peek() == '/' && stack.size() > 1) {
            stack.pop();
        }
        if (stack.peek() == '.' && stack.size() > 1) {
            stack.pop();
        }
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
