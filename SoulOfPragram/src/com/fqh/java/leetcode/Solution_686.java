package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_686 {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }


    public static int repeatedStringMatch(String a, String b) {
        int[] next = kmpNext(b);

        int j = 0;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder(a);
        for (int i = 0; i < b.length() / a.length() + 2; i++) {
            count++;
            for (int k = 0; k < stringBuilder.length(); k++) {
                while (j > 0 && stringBuilder.charAt(k) != b.charAt(j)) {
                    j = next[j - 1];
                }
                if (stringBuilder.charAt(k) == b.charAt(j)) {
                    j++;
                }

                if (j == b.length()) {
                    return count;
                }
            }
            j = 0;
            stringBuilder.append(a);
        }
        return -1;
    }

    public static int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {

            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
