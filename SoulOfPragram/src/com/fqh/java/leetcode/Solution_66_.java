package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 066. 单词之和
 */
public class Solution_66_ {

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
//        System.out.println(mapSum.sum("p"));
    }
}

class MapSum {

    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int[] next = kmpNext(prefix);
            String str = entry.getKey();
            int j = 0;

            for (int i = 0; i < str.length(); i++) {
                while (j > 0 && str.charAt(i) != prefix.charAt(j)) {
                    j = next[j - 1];
                }
                if (str.charAt(i) == prefix.charAt(j)) {
                    j++;
                }
                if (j == prefix.length()) {
                    if (str.startsWith(prefix)) {
                        sum += entry.getValue();
                    }
                    break;
                }
            }
        }
        return sum;
    }

    public int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
