package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1614. 括号的最大嵌套深度
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 */
public class Solution_1614 {

    public static void main(String[] args) {
        String s =  "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int depth = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                depth++;
                max = depth > max ? depth : max;
            }else if (chars[i] == ')') {
                depth--;
            }
        }
        return max;
    }
}
