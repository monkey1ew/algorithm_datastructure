package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1381. 设计一个支持增量操作的栈
 */
public class Solution_1381 {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(Arrays.toString(customStack.getStack()));
    }
}

class CustomStack {
    private int[] stack;
    private int maxsize;
    private int top;
    public CustomStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[maxsize];
        top = -1;
    }


    public void push(int x) {
        if (top == maxsize - 1) {
            throw new RuntimeException("stack is full");
        }
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            throw new RuntimeException("stack is empty");
        }
        return stack[top--];
    }

    public void increment(int k, int val) {
        System.out.println(top);
        if (top < k) {
            for (int i = 0; i <= top; i++) {
                stack[i] += val;
            }
        }else {
            for (int i = 0; i < k; i++) {
                stack[i] += val;
            }
        }
    }


    public int[] getStack() {
        return stack;
    }
}
