package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 216. 组合总和 III
 */
public class Solution_216 {

    public static void main(String[] args) {

        int k = 3;
        int n = 9;
        combinationSum3(k, n);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(k, n, 1, res, list);
        System.out.println(res);

        return res;
    }

    public static void backtrack(int k, int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            if (sum(list) == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(k, n, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
