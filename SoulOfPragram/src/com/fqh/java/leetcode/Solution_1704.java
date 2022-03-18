package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1704. 判断字符串的两半是否相似
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 */
public class Solution_1704 {

    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        char[] c1 = s.substring(0, s.length() / 2).toCharArray();
        char[] c2 = s.substring(s.length() / 2, s.length()).toCharArray();

        int count1 = 0;
        int count2 = 0;
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        for (int i = 0; i < c1.length; i++) {
            if (list.contains(c1[i])) {
                count1++;
            }
            if (list.contains(c2[i])) {
                count2++;
            }
        }
        return count1 == count2;
    }
}
