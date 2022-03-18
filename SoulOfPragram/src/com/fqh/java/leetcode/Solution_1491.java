package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1491. 去掉最低工资和最高工资后的工资平均值
 */
public class Solution_1491 {

    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(average(salary));
    }

    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : salary) {
            max = Math.max(j, max);
        }
        for (int i : salary) {
            min = Math.min(i, min);
        }
        double ans = 0;
        int count = 0;
        for (int k : salary) {
            if (k == max || k == min) {
                continue;
            }
            count++;
            ans += k;
        }
        return ans / count;
    }
}
