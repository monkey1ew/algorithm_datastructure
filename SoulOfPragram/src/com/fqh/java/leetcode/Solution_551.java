package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 551. 学生出勤记录 I
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 */
public class Solution_551 {

    public static void main(String[] args) {
        String s = "LLPPPLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    lCount++;
                }else {
                    lCount--;
                }
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        if (map.get('A') != null && map.get('A') >= 2) {
            return false;
        }
        if (map.get('L') != null && map.get('L') >= 3 && lCount >= 3) {
            return false;
        }
        return true;
    }
}
