package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 2085. 统计出现过一次的公共字符串
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 */
public class Solution_2085 {

    public static void main(String[] args) {

    }

    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (String str : words1) {
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String str : words2) {
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey()) && map1.get(entry.getKey()) < 2) {
                if (map2.get(entry.getKey()) < 2) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
