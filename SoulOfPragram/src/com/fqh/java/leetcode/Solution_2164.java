package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 2164. 对奇偶下标分别排序
 */
public class Solution_2164 {

    public static void main(String[] args) {

        int[] nums = {36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34};
        int[] ints = sortEvenOdd(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortEvenOdd(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                list2.add(nums[i]);
            }else {
                list1.add(nums[i]);
            }
        }
        Collections.sort(list1, ((o1, o2) -> (o2 - o1)));
        Collections.sort(list2);
        int[] ans = new int[nums.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 0) {
                ans[i] = list2.get(index2++);
            }else {
                ans[i] = list1.get(index1++);
            }
        }
        return ans;
    }
}
