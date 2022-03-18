package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 */
public class Solution_81_ {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(candidates, target, 0, res, list);

//        System.out.println(res);

        return res;
    }

    public static void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
        if (sum(list) == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum(list) + candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target, i, res, list);
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
