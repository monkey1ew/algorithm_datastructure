package com.fqh.java.leetcode;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_205 {

    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) != (tMap.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
