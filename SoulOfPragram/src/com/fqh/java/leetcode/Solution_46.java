package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 46. 全排列
 */
public class Solution_46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backtrack(nums, list, resultList);
        return resultList;
    }

    public static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> resultList) {
        if (list.size() == nums.length) { //到达决策树的底层, 结束递归
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) { //重复的就跳过
                continue;
            }
            list.add(nums[i]); //做选择
            backtrack(nums, list, resultList); //递归
            list.remove(list.size() - 1); //回溯一次删除末尾元素
        }
    }
}
