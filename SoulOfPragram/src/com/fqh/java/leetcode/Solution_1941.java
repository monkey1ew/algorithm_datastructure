package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 1941. 检查是否所有字符出现次数相同
 * 输入：s = "abacbc"
 * 输出：true
 * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
 */
public class Solution_1941 {

    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(areOccurrencesEqual(s));
    }

    public static boolean areOccurrencesEqual(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }
        System.out.println(map);
        return true;
    }
}
