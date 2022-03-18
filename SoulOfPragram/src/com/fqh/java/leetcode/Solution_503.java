package com.fqh.java.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 503. 下一个更大元素 II
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 */
public class Solution_503 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        nextGreaterElements(nums);
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            //利用取模防止index越界
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
