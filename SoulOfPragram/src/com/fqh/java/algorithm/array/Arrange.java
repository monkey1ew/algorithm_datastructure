package com.fqh.java.algorithm.array;



import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 全排列
 */
public class Arrange {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(arrange(nums));
    }

    public static List<List<Integer>> arrange(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, res, list);

        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list) {
        //到达叶子节点
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (list.contains(nums[i])) {
                continue;
            }
            // 做选择
            list.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, res, list);
            // 取消选择
            list.remove(list.size() - 1);
        }
    }
}
