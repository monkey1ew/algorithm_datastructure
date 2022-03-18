package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 2149. 按符号重排数组
 */
public class Solution_2149 {

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        rearrangeArray(nums);
    }

    public static int[] rearrangeArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list1.add(nums[i]);
            }else {
                list2.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 0) {
                ans[i] = list1.get(j++);
                continue;
            }
            ans[i] = list2.get(k++);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
