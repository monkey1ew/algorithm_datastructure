package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 面试题 16.02. 单词频率
 */
public class Solution_16 {

    public static void main(String[] args) {
        String[] strings = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency = new WordsFrequency(strings);
        int count = wordsFrequency.get("have");
        System.out.println(count);
    }
}

class WordsFrequency {
    Map<String, Integer> map = new HashMap<>();
    public WordsFrequency(String[] book) {
        for (int i = 0; i < book.length; i++) {
            map.put(book[i], map.getOrDefault(book[i], 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}