package com.fqh.java.leetcode;

import java.util.*;


/**
 * @author 海盗狗
 * @version 1.0
 * 2053. 数组中第 K 个独一无二的字符串
 */
public class Solution_2053 {

    public static void main(String[] args) {

        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() == 1) {
                count++;
                if (count == k) {
                    return list.get(i).getKey();
                }
            }
        }
        return " ";
    }
}
