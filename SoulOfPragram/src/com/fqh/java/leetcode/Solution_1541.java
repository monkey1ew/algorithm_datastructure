package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 1541. 平衡括号字符串的最少插入次数
 * 输入：s = "))())("
 * 输出：3
 * 解释：添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
 */
public class Solution_1541 {

    public static void main(String[] args) {
        String s = "))())(";
        System.out.println(minInsertions(s));
    }


    public static int minInsertions(String s) {

        int leftNeed = 0;
        int rightNeed = 0; //右括号需求量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightNeed += 2; //一个左括号需要2个右括号
                if (rightNeed % 2 == 1) { //如果右括号需求为奇数
                    leftNeed++;  //左 + 1
                    rightNeed--; //右 - 1
                }
            } else {
                rightNeed -= 1;
                if (rightNeed == -1) { //多余的右
                    leftNeed++; //左+1
                    rightNeed = 1; //同时对右 + 1
                }
            }
        }
        return leftNeed + rightNeed;
    }
}
