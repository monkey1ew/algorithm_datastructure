package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2042. 检查句子中的数字是否递增
 */
public class Solution_2042 {

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));
    }


    public static boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");
        int count = 0;
        for (String str : strings) {
            if (str.charAt(0) >= 49 && str.charAt(0) <= 57) {
                if (Math.max(count, Integer.parseInt(str)) == count) {
                    return false;
                }
                count = Integer.parseInt(str);
            }
        }
        return true;
    }
}
