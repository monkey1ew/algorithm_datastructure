package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 2103. 环和杆
 * 输入：rings = "B0B6G0R6R0R6G9"
 * 输出：1
 * 解释：
 * - 编号 0 的杆上有 3 个环，集齐全部颜色：红、绿、蓝。
 * - 编号 6 的杆上有 3 个环，但只有红、蓝两种颜色。
 * - 编号 9 的杆上只有 1 个绿色环。
 * 因此，集齐全部三种颜色环的杆的数目为 1 。
 */
public class Solution_2103 {

    public static void main(String[] args) {

        String rings = "B0B6G0R6R0R6G9";
        System.out.println(countPoints(rings));
    }

    public static int countPoints(String rings) {
        Map<Character, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i+=2) {
            HashSet<Character> set = new HashSet<>();
            set.add(rings.charAt(i));
            if (map.containsKey(rings.charAt(i + 1))) {
                map.get(rings.charAt(i + 1)).add(rings.charAt(i));
            }else {
                map.put(rings.charAt(i + 1), set);
            }

        }
//        System.out.println(map);
        List<Map.Entry<Character, HashSet<Character>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, HashSet<Character>>>() {
            @Override
            public int compare(Map.Entry<Character, HashSet<Character>> o1, Map.Entry<Character, HashSet<Character>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue().size() == 3) {
                count++;
            }
        }
        return count;
    }
}
