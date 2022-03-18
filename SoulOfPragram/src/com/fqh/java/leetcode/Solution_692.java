package com.fqh.java.leetcode;

import java.sql.Connection;
import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 692. 前K个高频单词
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 */
public class Solution_692 {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        topKFrequent(words, k);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            }else {
                return o1.getValue() - o2.getValue();
            }

        }));
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        LinkedList<String> stack = new LinkedList<>();
        while (!pq.isEmpty()) {
            stack.push(pq.poll().getKey());
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
