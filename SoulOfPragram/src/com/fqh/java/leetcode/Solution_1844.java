package com.fqh.java.leetcode;

import java.util.Locale;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 1844. 将所有数字用字符替换
 * 输入：s = "a1c1e1"
 * 输出："abcdef"
 * 解释：数字被替换结果如下：
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('c',1) = 'd'
 * - s[5] -> shift('e',1) = 'f'
 */
public class Solution_1844 {

    public static void main(String[] args) {

        String s = "a1c1e1";
        System.out.println(replaceDigits(s));
    }

    public static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 1) {
                c = (char) (s.charAt(i - 1) + c - '0');
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
