package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 08.07. 无重复字符串的排列组合
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 */
public class Solution_08 {

    public static void main(String[] args) {
        String S = "qwe";
        System.out.println(Arrays.toString(permutation(S)));
    }

    public static String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] isVisited = new boolean[S.length()];
        List<Character> list = new ArrayList<>();

        backtrack(S, isVisited, res, list, stringBuilder);
        int index = 0;
        String[] result = new String[res.size()];
        for (String element : res) {
            result[index++] = element;
        }
        return result;
    }


//    public static void back(String s, boolean[] isVisited, List<List<Character>> res, List<Character> list) {
//        if (list.size() == s.length()) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (list.contains(s.charAt(i)) && isVisited[i]) {
//                continue;
//            }
//            isVisited[i] = true;
//            list.add(s.charAt(i));
//            back(s, isVisited, res, list);
//            list.remove(list.size() - 1);
//            isVisited[i] = false;
//        }
//    }

    public static void backtrack(String s, boolean[] isVisited, List<String> res, List<Character> list, StringBuilder stringBuilder) {
        if (list.size() == s.length()) {
            res.add(new String(stringBuilder));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i)) && isVisited[i]) {
                continue;
            }
            list.add(s.charAt(i));
            isVisited[i] = true;
            stringBuilder.append(s.charAt(i));
            backtrack(s, isVisited, res, list, stringBuilder);
            list.remove(list.size() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            isVisited[i] = false;
        }
    }
}
