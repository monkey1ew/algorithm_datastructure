package com.fqh.java.leetcode;

import javax.swing.plaf.LabelUI;
import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 40. 组合总和 II
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class Solution_40 {

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(candidates, target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[candidates.length];
        backtrack(candidates, 0, target, res, list, isVisited);
//        System.out.println(res);

        Set<List<Integer>> set = new HashSet<>();
        set.addAll(res);
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(set);
        System.out.println(ans);
        return ans;
    }

    public static void backtrack(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> list, boolean[] isVisited) {
        if (sum(list) == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (sum(list) + candidates[i] > target) {
                continue;
            }
            isVisited[i] = true;
            list.add(candidates[i]);
            backtrack(candidates, i + 1, target, res, list, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
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
