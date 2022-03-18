package com.fqh.java.structure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 单调栈
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }

    public static int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) { //倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]) { //判定高矮个子
                stack.pop(); //矮个子出列
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek(); //这个元素身后的第一个高个
            stack.push(nums[i]); //进队
        }
        return res;
    }
}
