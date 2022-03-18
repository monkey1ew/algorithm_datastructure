package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 1598. 文件夹操作日志搜集器
 */
public class Solution_1598 {

    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","./","d3/","../","d31/"};

        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String str : logs) {
            if (str.equals("../")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }else if (str.equals("./")) {
                continue; //停留
            }else {
                stack.push(str);
            }
        }

        System.out.println(stack);
        return stack.size();
    }
}
