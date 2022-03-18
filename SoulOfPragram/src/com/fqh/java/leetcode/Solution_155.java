package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 155.最小栈
 */
public class Solution_155 {

    public static void main(String[] args) {

    }

    static class MinStack {
        private Stack<Integer> main;
        private Stack<Integer> min;

        public MinStack() {
            main = new Stack<>();
            min = new Stack<>();
        }
        public void push(int val) {
            main.push(val);
//            如果min栈为null或者小于min栈顶元素就入栈
            if(min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }
        }
        public void pop() {
            if(main.isEmpty()) {
                return;
            }
//            如果main栈的栈顶元素等于min栈的栈顶元素,就弹出min
            if(main.peek().equals(min.peek())) {
                min.pop();
            }
            main.pop();
        }
        public int top() {
            if(main.isEmpty()) {
                throw new RuntimeException("main is Empty");
            }
            return main.peek();
        }
//        min栈的栈顶总是存放最小的元素
        public int getMin() {
            return min.peek();
        }
    }
}
