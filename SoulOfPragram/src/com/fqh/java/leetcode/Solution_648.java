package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 648. 单词替换
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 */
public class Solution_648 {

    public static void main(String[] args) {
//        String[] dictionary = {"cat", "bat", "rat"};
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(replaceWords(dictionary, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] strings = sentence.split(" ");
        int index = 0;
        for (String str : strings) {
            for (String pattern : dictionary) {
                int[] next = kmpNext(pattern);
                int j = 0;
                for (int i = 0; i < str.length(); i++) {
                    while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                        j = next[j - 1];
                    }
                    if (str.charAt(i) == pattern.charAt(j)) {
                        j++;
                    }
                    if (j == pattern.length()) {
                        if (str.startsWith(pattern)) {
                            strings[index] = pattern;
                            System.out.println(strings[index]);
                            break;
                        }
                        j = 0;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String link : strings) {
            sb.append(link + " ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public static int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        next[0] = 0;
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
