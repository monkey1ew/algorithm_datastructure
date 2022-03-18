package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 080. 含有 k 个元素的组合
 */
public class Solution_80_ {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        combine(n, k);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(n, k, 1, res, list);
        System.out.println(res);

        return res;
    }

    public static void backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n, k, i + 1, res,list );
            list.remove(list.size() - 1);
        }
    }
}
