package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1935. 可以输入的最大单词数
 * 输入：text = "hello world", brokenLetters = "ad"
 * 输出：1
 * 解释：无法输入 "world" ，因为字母键 'd' 已损坏。
 */
public class Solution_1935 {

    public static void main(String[] args) {

        String text = "hello world";
        String brokenLetters = "ad";
        canBeTypedWords(text, brokenLetters);
    }

    public static int canBeTypedWords(String text, String brokenLetters) {

        String[] s = text.split(" ");
        List<Character> list = new ArrayList<>();
        for (char c : brokenLetters.toCharArray()) {
            list.add(c);
        }
        int ans = 0;
        boolean flag = true;
        for (String str : s) {
            for (char c : str.toCharArray()) {
                if (list.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
            flag = true;
        }
        System.out.println(ans);
        return ans;
    }
}
