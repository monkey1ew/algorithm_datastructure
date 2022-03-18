package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2000. 反转单词前缀
 * 输入：word = "abcdefd", ch = "d"
 * 输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 */
public class Solution_2000 {

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                String substring = word.substring(0, i + 1);
                StringBuilder stringBuilder = new StringBuilder(substring);
                stringBuilder.reverse();

                return stringBuilder + word.substring(i + 1, word.length());
            }
        }
        return word;
    }
}
