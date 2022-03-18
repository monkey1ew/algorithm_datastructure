package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 39. 组合总和
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 */
public class Solution_39 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, 0, target, res, list);

        System.out.println(res);
        return res;
    }

    public static void backtrack(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> list) {
        if (sum(list) == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum(list) + candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, i, target, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        return sum;
    }
}
