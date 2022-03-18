package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 1394. 找出数组中的幸运数
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 */
public class Solution_1394 {

    public static void main(String[] args) {

        int[] arr = {2, 2, 3 ,4};
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        if (arr.length == 1) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getKey() == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
