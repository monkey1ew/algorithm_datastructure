package com.fqh.java.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Solution_50_ {

    public static void main(String[] args) {

        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }

    public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
