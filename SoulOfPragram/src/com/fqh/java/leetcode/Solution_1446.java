package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 1446. 连续字符
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 */
public class Solution_1446 {

    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int count = 1;
        char temp = s.charAt(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (temp == s.charAt(i)) {
                count++;
                list.add(count);
            }else {
                temp = s.charAt(i);
                count = 1;
            }
        }
        if(list.size() == 0) {
            return 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i : list) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
