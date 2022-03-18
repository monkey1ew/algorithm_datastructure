package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1408. 数组中的字符串匹配输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-matching-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1408 {

    public static void main(String[] args) {

        String[] words = {"uexk","aeuexkf","wgxih","yuexk","gxea","yuexkm","ypmfx","jjuexkmb","wqpri","aeuexkfpo","kqtnz","pkqtnza","nrbb","hmypmfx","krqs","jjuexkmbyt","zvru","ypmfxj"};
        stringMatching(words);
    }

    public static List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int[] next = kmpNext(words[i]);
            int k = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].length() > words[j].length() || words[i].equals(words[j])) {
                    continue;
                }
                for (int l = 0; l < words[j].length(); l++) {
                    while (k > 0 && words[j].charAt(l) != words[i].charAt(k)) {
                        k = next[k - 1];
                    }
                    if (words[j].charAt(l) == words[i].charAt(k)) {
                        k++;
                    }
                    if (k == words[i].length()) {
                        if (!res.contains(words[i])) {
                            res.add(words[i]);
                        }
                        k = 0;
                    }
                }
            }
        }
        System.out.println(res);
        return res;
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
