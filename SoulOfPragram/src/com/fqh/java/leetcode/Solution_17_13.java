package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 17.13. 恢复空格
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 */
public class Solution_17_13 {

    public static void main(String[] args) {
        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(respace(dictionary, sentence));
    }

    public static int respace(String[] dictionary, String sentence) {
        List<String> list = new ArrayList<>();
        int hasCover = 0;
        for (String str : dictionary) {
            int[] next = kmpNext(str);
            int j = 0;
            for (int i = 0; i < sentence.length(); i++) {
                while (j > 0 && sentence.charAt(i) != str.charAt(j)) {
                    j = next[j - 1];
                }
                if (sentence.charAt(i) == str.charAt(j)) {
                    j++;
                }
                if (j == str.length()) {
                    hasCover += str.length();
                    j = 0;
                }
            }
        }

        return sentence.length() - hasCover;
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
