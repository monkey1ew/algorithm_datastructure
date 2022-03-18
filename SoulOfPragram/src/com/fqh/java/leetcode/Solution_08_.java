package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 08.06. 汉诺塔问题
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 */
public class Solution_08_ {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        hanota(A, B, C);
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
        System.out.println(C.size());

    }

    public static void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(n - 1, B, A, C);
    }
}
