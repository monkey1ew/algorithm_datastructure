package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 682. 棒球比赛
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 */
public class Solution_682 {

    public static void main(String[] args) {

        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if (str.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.peek();
                stack.push(num1);
                stack.push(num1 + num2);
            }else if (str.equals("D")) {
                int num = stack.peek();
                stack.push(2 * num);
            }else if (str.equals("C")) {
                stack.pop();
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        int res = 0;
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            res += stack.pop();
        }
        return res;
    }
}
