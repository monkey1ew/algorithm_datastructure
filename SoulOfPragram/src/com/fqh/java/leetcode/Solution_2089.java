package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 2089. 找出数组排序后的目标下标
 */
public class Solution_2089 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;
        System.out.println(targetIndices(nums, 2));
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                int insertValue = nums[j];
                if (nums[j] < nums[j - gap]) {
                    while (j - gap > 0 && insertValue < nums[j - gap]) {
                        nums[j] = nums[j - gap];
                        j -= gap;
                    }
                }
                nums[j] = insertValue;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list;
    }
}
