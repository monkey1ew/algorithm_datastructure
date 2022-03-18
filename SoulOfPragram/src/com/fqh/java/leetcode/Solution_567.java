package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> w_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            t_map.put(s1.charAt(i), i);
        }
        System.out.println(t_map);
        int left = 0;
        int right = 0;
        int count = 0;


        while (right < s2.length() || w_map.size() < 2) {
            char c = s2.charAt(right);
            right++;

            if (t_map.containsKey(c)) {
                w_map.put(c, w_map.getOrDefault(c, 0) + 1);
                if (w_map.get(c).equals(t_map.get(c))) {
                    count++;
                }
            }
            System.out.println(w_map);
            while (count == s1.length()) {
//                return true;

                char d = s2.charAt(left);
                left++;
                if (t_map.containsKey(d)) {
                    if (t_map.get(c).equals(w_map.get(c))) {
                        count--;
                    }
                    w_map.put(d, w_map.get(d) - 1);
                }
            }
        }
//        System.out.println(s2.substring(start, start + len));
//        return len == Integer.MAX_VALUE ? "" : s2.substring(start, start + len);
        return w_map.size() == 2;
    }
}
