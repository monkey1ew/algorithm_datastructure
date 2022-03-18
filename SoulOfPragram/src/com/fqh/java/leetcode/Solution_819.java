package com.fqh.java.leetcode;

import java.sql.Connection;
import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 819.最常见的单词
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class Solution_819 {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println('a' + 1); //'a' -> 97
        System.out.println('z' + 1); // 'z' -> 122
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String newParargraph = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        List<String> bannedList = new ArrayList<>();
        for (String bannedStr : banned) {
            bannedList.add(bannedStr);
        }

        int startIndex = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            if (newParargraph.charAt(i) >= 97 && newParargraph.charAt(i) <= 122) {
                continue;
            }else {
                String s = newParargraph.substring(startIndex, i);
                map.put(s, map.getOrDefault(s, 0) + 1);
                startIndex = i + 1;
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println(list);
        int res = Integer.MIN_VALUE;
        System.out.println(bannedList);
        for (int i = 0; i < list.size(); i++) {
            if (!bannedList.contains(list.get(i).getKey())) {
                return list.get(i).getKey();
            }
        }
        return null;
    }
}
