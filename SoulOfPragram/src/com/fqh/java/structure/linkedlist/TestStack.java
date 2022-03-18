package com.fqh.java.structure.linkedlist;

import java.util.Stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 演示栈的使用
 */
public class TestStack {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        //出栈 先进后出
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
