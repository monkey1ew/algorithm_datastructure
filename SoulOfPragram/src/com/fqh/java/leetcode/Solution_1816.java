package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1816. 截断句子
 */
public class Solution_1816 {

    public static void main(String[] args) {

        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    public static String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split(" ");
        int count = 0;
        for (String str : strings) {
            if (count == k) {
                break;
            }
            sb.append(str).append(" ");
            count++;
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }
}
