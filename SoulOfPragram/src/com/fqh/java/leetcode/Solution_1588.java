package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1588. 所有奇数长度子数组的和
 */
public class Solution_1588 {
    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 5, 3};

        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(arr, res, list);
        System.out.println(res);
        return -1;
    }

    public static void backtrack(int[] arr, List<List<Integer>> res, List<Integer> list) {
        if(list.size() % 2 != 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            backtrack(arr, res, list);
            list.remove(list.size() - 1);
        }
    }
}
