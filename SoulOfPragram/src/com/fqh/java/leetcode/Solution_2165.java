package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 2165. 重排数字的最小值
 * 输入：num = 310
 * 输出：103
 * 解释：310 中各位数字的可行排列有：013、031、103、130、301、310 。
 * 不含任何前导零且值最小的重排数字是 103 。
 */
public class Solution_2165 {

    public static void main(String[] args) {

        long num = 95005;
        System.out.println(smallestNumber(num));
    }

    public static long smallestNumber(long num) {

        String s = String.valueOf(num);
        if (s.contains("-")) {
            char[] chars = s.substring(1).toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder(String.valueOf(chars));
            return Long.parseLong("-" + sb.reverse());
        }

        if (s.contains("0")) {
            if(s.length() == 1) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            int zeroLen = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0') {
                    zeroLen++;
                }
            }
            String str = String.valueOf(chars);
            StringBuilder sb = new StringBuilder(str.substring(zeroLen, zeroLen + 1));
            for (int i = 0; i < zeroLen; i++) {
                sb.append('0');
            }
            sb.append(str.substring(zeroLen + 1));
            return Long.parseLong(sb.toString());
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Long.parseLong(String.valueOf(chars));
    }
}
