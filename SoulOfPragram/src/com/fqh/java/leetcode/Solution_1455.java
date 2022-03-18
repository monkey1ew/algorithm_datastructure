package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1455. 检查单词是否为句中其他单词的前缀
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 *
 */
public class Solution_1455 {

    public static void main(String[] args) {
        String sentence = "hellohello hellohellohello", searchWord = "ell";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }


    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        int[] next = kmpNext(searchWord);
        int j = 0;
        int index = 1;
        for (String element : split) {
            for (int i = 0; i < element.length(); i++) {
                while (j > 0 && element.charAt(i) != searchWord.charAt(j)) {
                    j = next[j - 1];
                }
                if (element.charAt(i) == searchWord.charAt(j)) {
                    j++;
                }
                if (j == searchWord.length()) {;
                    if(!element.startsWith(searchWord)) {
                        j = 0;
                        break;
                    }
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    public static int[] kmpNext(String searchWord) {
        int[] next = new int[searchWord.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < searchWord.length(); i++) {
            while (j > 0 && searchWord.charAt(i) != searchWord.charAt(j)) {
                j = next[j - 1];
            }
            if (searchWord.charAt(i) == searchWord.charAt(j)) {
                j++;
            }
            next[i] =j;
        }
        return next;
    }
}
