package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 1282. 用户分组
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 *
 */
public class Solution_1282 {

    public static void main(String[] args) {

        int[] groupSizes = {3,3,3,3,3,1,3};
        groupThePeople(groupSizes);
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            map.put(groupSizes[i], map.getOrDefault(groupSizes[i], 0) + 1);
        }
        System.out.println(map);
        int index = 0;

        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 1) {
                index = i;
            }
        }
        System.out.println(index);

        return res;
    }
}
