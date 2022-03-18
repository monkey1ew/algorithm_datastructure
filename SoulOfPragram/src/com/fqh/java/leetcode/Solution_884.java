package com.fqh.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 884. 两句话中的不常见单词
 */
public class Solution_884 {

    public static void main(String[] args) {

        String s1 = "this apple is sweet", s2 = "this apple is sour";

        String[] strings = uncommonFromSentences(s1, s2);
        System.out.println(Arrays.toString(strings));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String str = s1 + " " + s2;
        Map<String, Integer> map = new HashMap<>();
        for(String s : str.split( " ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1).split(" ");
    }
}
