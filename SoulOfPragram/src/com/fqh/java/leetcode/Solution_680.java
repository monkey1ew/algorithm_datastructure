package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_680 {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(2, 3));
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        StringBuilder sb =new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                String pre = s.substring(0, i);
                String last = s.substring(i, s.length());
                sb.append(pre).append(last);
                if (sb.toString().equals(sb.reverse().toString())) {
                    return true;
                }
                sb.delete(0, sb.length() - 1);
            }
            sb.append(s.substring(1, s.length()));
            if (sb.toString().equals(sb.reverse().toString())) {
                return true;
            }
            sb.delete(0, sb.length() - 1);
        }
        return false;
    }
}
