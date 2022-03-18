package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 2138. 将字符串拆分为若干长度为 k 的组
 */
public class Solution_2138 {

    public static void main(String[] args) {

        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        divideString(s, k, fill);
    }

    public static String[] divideString(String s, int k, char fill) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i += k) {
            if (i + k > s.length()) {
                res.add(s.substring(i));
                break;
            }
            res.add(s.substring(i, i + k));
        }
        String[] ans = new String[res.size()];
        int index = 0;
        for (String str : res) {
            if (str.length() < k) {
                int incr = k - str.length();
                StringBuilder sb = new StringBuilder(str);
                while (incr-- > 0) {
                    sb.append(fill);
                }
                ans[index++] = sb.toString();
                continue;
            }
            ans[index++] = str;
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }

}