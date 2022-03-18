package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 1859. 将句子排序
 * 输入：s = "is2 sentence4 This1 a3"
 * 输出："This is a sentence"
 * 解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 sentence4" ，然后删除数字。
 */
public class Solution_1859 {

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        String[] strings = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (String element : strings) {
            map.put(element.charAt(element.length() - 1) + 0, element.substring(0, element.length() - 1));
        }
        System.out.println(map);
        StringBuilder sentence = new StringBuilder();
        for (String str : map.values()) {
            sentence.append(str + " ");
        }
        return new String(sentence.deleteCharAt(sentence.length() - 1));
    }
}
