package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1286. 字母组合迭代器
 */
public class Solution_1286 {

    public static void main(String[] args) {

        CombinationIterator iterator = new CombinationIterator("abc", 2);
        iterator.next();
        iterator.hasNext();
        iterator.next();
        iterator.hasNext();
    }
}

class CombinationIterator {
    List<StringBuilder> res;
    int index = 0;
    public CombinationIterator(String characters, int combinationLength) {
        res = combine(characters, combinationLength);

    }

    public String next() {
        return res.get(index++).toString();
    }

    public boolean hasNext() {
        return index <= res.size();
    }

    public List<StringBuilder> combine(String s, int k) {
        List<StringBuilder> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(s.toCharArray(), 0, k, res, sb);
        return res;
    }

    public void backtrack(char[] chars, int start, int k, List<StringBuilder> res, StringBuilder sb) {
        if (sb.length() == k) {
            res.add(new StringBuilder(sb.toString()));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            sb.append(chars[i]);
            backtrack(chars, i + 1, k, res, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */