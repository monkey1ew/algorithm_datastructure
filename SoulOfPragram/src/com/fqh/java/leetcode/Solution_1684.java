package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1684. 统计一致字符串的数目
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 */
public class Solution_1684 {

    public static void main(String[] args) {

        String allowed = "fstqyienx";
        String[] words = {"n","eeitfns","eqqqsfs","i","feniqis","lhoa","yqyitei","sqtn","kug","z","neqqis"};
        countConsistentStrings(allowed, words);
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        List<Character> list = new ArrayList<>();
        for (char c : allowed.toCharArray()) {
            list.add(c);
        }
        int res = words.length;
        for (String element : words) {
            for (int i = 0; i < element.length(); i++) {
                if (!list.contains(element.charAt(i))) {
                    res--;
                    break;
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
