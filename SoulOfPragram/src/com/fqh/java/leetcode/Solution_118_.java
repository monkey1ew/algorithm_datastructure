package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 118. 杨辉三角
 */
public class Solution_118_ {

    public static void main(String[] args) {

        int numRows = 5;
        generate(numRows);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                res.add(list);
                continue;
            }
            if (i == 1) {
                list.add(1);
                list.add(1);
                res.add(list);
                continue;
            }
            for (int j = 0; j < res.get(i - 1).size() + 1; j++) {
                if (j == 0) {
                    list.add(1);
                }else {
                    if (j + 1 < res.get(i - 1).size() + 1) {
                        list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j + 1));
                    }
                }
                res.add(list);
            }
        }
        for (List<Integer> link : res) {
            System.out.println(link);
        }
        return res;
    }
}
