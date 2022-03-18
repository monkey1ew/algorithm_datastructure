package com.fqh.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 17.17. 多次搜索
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]。
 */
public class Solution_17_ {

    public static void main(String[] args) {
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        String big = "mississippi";
        multiSearch(big, smalls);
        String[] strings = {""};
        System.out.println(new int[0][1]);
    }

    public static int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> resList = new ArrayList<>();
        for (String pattern : smalls) {
            int[] next = kmpNext(pattern);
            int j = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < big.length(); i++) {
                while (j > 0 && big.charAt(i) != pattern.charAt(j)) {
                    j = next[j - 1];
                }
                if (big.charAt(i) == pattern.charAt(j)) {
                    j++;
                }
                if (j == pattern.length()) {
                    list.add(i - j + 1);
                    j = 0;
                }
            }
            resList.add(list);
        }
        int[][] res = new int[resList.size()][resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            int[] arr = new int[resList.get(i).size()];
            for (int j = 0; j < resList.get(i).size(); j++) {
                arr[j] = resList.get(i).get(j);
            }
            res[i] = arr;
        }
        return res;
    }

    public static int[] kmpNext(String pattern) {
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
