package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 387. 字符串中的第一个唯一字符
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 */
public class Solution_387 {

    public static void main(String[] args) {

        String s = "loveleetcode";
        firstUniqChar(s);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        List<Character> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : list) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        if (ans.size() == 0) {
            return -1;
        }
        int firstIndex = Integer.MAX_VALUE;
        for (char c : ans) {
            for (int i = 0; i < chars.length; i++) {
                if (c == chars[i]) {
                    firstIndex = Math.min(firstIndex, i);
                }
            }
        }
//        System.out.println(firstIndex);
        return firstIndex;
    }
}
