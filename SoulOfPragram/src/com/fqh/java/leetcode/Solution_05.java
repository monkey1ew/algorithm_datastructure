package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 05. 替换空格
 */
public class Solution_05 {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(s.length());
        System.out.println(replaceSpace(s));

    }

    public static String replaceSpace(String s) {
        String result = "";
        String[] split = s.split(" ");

        if (split.length == 0) {
            for (int i = 0; i < s.length(); i++) {
                result += "%20";
            }
            return result;
        }
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(" ")) {
                result += "%20";
            }else {
                result += split[i] + "%20";
            }
        }
        if (split.length < 3) {
            return result;
        }
        return result.substring(0, result.length() - 3);
    }
}
