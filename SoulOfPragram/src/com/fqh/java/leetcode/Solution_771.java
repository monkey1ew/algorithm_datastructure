package com.fqh.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 771. 宝石与石头
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 */
public class Solution_771 {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();;
        char[] c1 = jewels.toCharArray();
        char[] c2 = stones.toCharArray();
        for(char c : c1) {
            set.add(c);
        }
        int num = 0;
        for (char c : c2) {
            if (set.contains(c)) {
                num += 1;
            }
        }
        return num;
    }
}
