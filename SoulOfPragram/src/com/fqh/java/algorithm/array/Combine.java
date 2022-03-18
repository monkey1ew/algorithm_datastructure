package com.fqh.java.algorithm.array;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 组合
 */
public class Combine {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    // 从1——n中 k个数字的组合
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(n, k, 1, res, list);

        return res;
    }

    public static void backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        // 到达叶子节点更新 res
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // i从start开始递增
        for (int i = start; i <= n; i++) {
            // 做选择
            list.add(i);
            // 递归回溯
            backtrack(n, k, i + 1, res, list);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}
