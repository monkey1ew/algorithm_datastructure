package com.fqh.java.leetcode;

import sun.plugin2.message.StartAppletAckMessage;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 739. 每日温度
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class Solution_739 {

    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        //维护单调栈, 保证后面进的元素比栈顶元素小
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i); //存索引
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
