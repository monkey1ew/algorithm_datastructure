package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * excel表格 A1:F1
 * 输出: A1,B1,C1,D1,F1
 */
public class LCP_3_6 {

    public static void main(String[] args) {

        String s = "U7:X9";
        System.out.println(cellsInRange(s));
        System.out.println('A' + 1); //A->65
        List<Integer> list = new ArrayList<>();

    }

    public static List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        int c = split[1].charAt(1) - '0';

        List<String> res = new ArrayList<>();
        char count = split[0].charAt(0);
        int start = split[0].charAt(1) - '0';

        while(count <= split[1].charAt(0)) {
            for (int i = start; i <= c; i++) {
                res.add(String.valueOf(count) + i);
            }
            count++;
        }
        return res;
    }
}
