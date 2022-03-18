package com.fqh.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 海盗狗
 * @version 1.0
 * 1832. 判断句子是否为全字母句
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 */
public class Solution_1832 {

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() >= 26;
    }
}
