package com.fqh.java.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class SlidingWindowAlgorithm {

    public static void main(String[] args) {
        String s = "ADBECFEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }


    public static String minWindow(String s, String t) {
        // 记录t 以及 滑动窗口window中 字符与个数的映射关系
        HashMap<Character, Integer> window_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            t_map.put(c1, t_map.getOrDefault(c1, 0) + 1);
        }
        System.out.println(t_map);
        // 双指针
        int left = 0;
        int right = 0;
        int count = 0;
        // 用于更新满足的窗口window的长度,如果是len一直是MAX_VALUE，说明没有满足的串
        int len = Integer.MAX_VALUE;
        // 用于记录window串的起始位置，则返回 s[start, len]
        int start = 0;
        //右移动窗口
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 只要c是t中出现的字符就更新
            if (t_map.containsKey(c)) {
                window_map.put(c, window_map.getOrDefault(c, 0) + 1);
                // 更新c字符出现的次数
                if (window_map.get(c).equals(t_map.get(c))) {
                    count++;
                }
            }
//             System.out.println(window_map);
            // ----------------------------------
            // 收缩window的长度
            while (count == t_map.size()) {
                // 更新并记录window的长度,以及window的起始位置start
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (t_map.containsKey(d)) {
                    if (window_map.get(d).equals(t_map.get(d))) {
                        count--;
                    }
                    window_map.put(d, window_map.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
