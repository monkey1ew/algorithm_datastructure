package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 1791. 找出星型图的中心节点
 */
public class Solution_1791 {

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] link : edges) {
            for (int i = 0; i < link.length; i++) {
                if (set.contains(link[i])) { //出现两次就返回
                    return link[i];
                }
                set.add(link[i]);
            }
        }
        return -1;
    }
}
