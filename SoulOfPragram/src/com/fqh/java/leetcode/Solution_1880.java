package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 1880. 检查某单词是否等于两单词之和
 * 输入：firstWord = "acb", secondWord = "cba", targetWord = "cdb"
 * 输出：true
 * 解释：
 * firstWord 的数值为 "acb" -> "021" -> 21
 * secondWord 的数值为 "cba" -> "210" -> 210
 * targetWord 的数值为 "cdb" -> "231" -> 231
 * 由于 21 + 210 == 231 ，返回 true
 */
public class Solution_1880 {

    public static void main(String[] args) {
       String firstWord = "acb", secondWord = "cba", targetWord = "cdb";
        System.out.println(isSumEqual(firstWord, secondWord, targetWord));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 1);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 4);
        map.put('f', 5);
        map.put('g', 6);
        map.put('h', 7);
        map.put('i', 8);
        map.put('j', 9);
        String firstVal = "";
        String secondVal = "";
        String targetVal = "";
        for (char c1 : firstWord.toCharArray()) {
            firstVal += map.get(c1);
        }
        for (char c2 : secondWord.toCharArray()) {
            secondVal += map.get(c2);
        }
        for (char c3 : targetWord.toCharArray()) {
            targetVal += map.get(c3);
        }
        return Integer.parseInt(firstVal) + Integer.parseInt(secondVal) == Integer.parseInt(targetVal);
    }

}
