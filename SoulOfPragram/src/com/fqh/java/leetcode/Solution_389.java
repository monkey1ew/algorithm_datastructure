package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 389. 找不同
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 */
public class Solution_389 {

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        char theDifference = findTheDifference(s, t);
        System.out.println(theDifference);

    }

    public static char findTheDifference(String s, String t) {

        return (char) (t.chars().sum() - s.chars().sum());
    }
}
