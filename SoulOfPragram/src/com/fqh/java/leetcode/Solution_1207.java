package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 1207. 独一无二的出现次数
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 */
public class Solution_1207 {

    public static void main(String[] args) {

        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        int times = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            times++;
            set.add(entry.getValue());
        }
        return times == set.size();
    }
}
