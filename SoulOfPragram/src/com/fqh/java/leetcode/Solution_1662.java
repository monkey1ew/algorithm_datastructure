package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1662. 检查两个字符串数组是否相等
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 */
public class Solution_1662 {

    public static void main(String[] args) {

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String element : word1) {
            sb1.append(element);
        }
        for (String element : word2) {
            sb2.append(element);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
