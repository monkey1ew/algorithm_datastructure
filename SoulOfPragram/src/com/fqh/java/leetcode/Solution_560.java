package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 560. 和为 K 的子数组
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class Solution_560 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;
        subarraySum(nums, 2);
    }


    public static int subarraySum(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];

        backtrack(nums, 0, res, list, k, isVisited);
        System.out.println(res);
//        Set<List<Integer>> set = new HashSet<>();
//        set.addAll(res);

//        System.out.println(set);
        int count = 0;
        for (List<Integer> link : res) {
            if (sum(link) == k) {
                count++;
            }
        }
//        System.out.println(count);
        return count - 1;
    }

    public static void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list, int k, boolean[] isVisited) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                if (isVisited[i]) {
                    continue;
                }
            }
            if (sum(list) + nums[i] > k) {
                continue;
            }
            isVisited[i] = true;
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list, k, isVisited);
            isVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static int sum(List<Integer> list) {
        int ans = 0;
        for (int i : list) {
            ans += i;
        }
        return ans;
    }
}
