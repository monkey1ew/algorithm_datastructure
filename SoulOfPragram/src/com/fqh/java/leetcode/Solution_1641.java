package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1641. 统计字典序元音字符串的数目
 */
public class Solution_1641 {

    public static void main(String[] args) {

        int n = 2;
        countVowelStrings(n);
    }

    public static int countVowelStrings(int n) {
        String[] arr = {"a", "e", "i", "o", "u"};
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrack(arr, 0, n,res , list);
//        System.out.println(res);
//        System.out.println(res.size());

        return res.size();
    }


    public static void backtrack(String[] arr, int start, int n, List<List<String>> res,List<String> list) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            backtrack(arr, i, n, res, list);
            list.remove(list.size() - 1);
        }
    }
}
