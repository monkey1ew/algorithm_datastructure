package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * LeetCode----13 :罗马数字转整数 VI = 5 + 1, XI = 10 + 1.......
 *         字符          数值
 *         I             1
 *         V             5
 *         X             10
 *         L             50
 *         C             100
 *         D             500
 *         M             1000
 **/
public class Solution_13 {

    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && map.get(chars[i]) < map.get(chars[i + 1])) {
                res += (map.get(chars[i + 1]) - map.get(chars[i]));
                i++;
            }else {
                res += map.get(chars[i]);
            }
        }
        return res;

    }
}
