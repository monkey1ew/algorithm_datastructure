package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 520. 检测大写字母
 */
public class Solution_520 {

    public static void main(String[] args) {

        String word = "g";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        int lowCount = 0;
        int upperCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                lowCount++;
            }else {
                upperCount++;
            }
        }
        if (lowCount == word.length()) {
            return true;
        }
        if (upperCount == word.length()) {
            return true;
        }
        if (upperCount == 1 && word.charAt(0) < 97) {
            return true;
        }
        return false;
    }
}
