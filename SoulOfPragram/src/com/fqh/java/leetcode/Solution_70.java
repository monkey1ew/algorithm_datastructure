package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 70. 爬楼梯
 */
public class Solution_70 {

    public static void main(String[] args) {

        System.out.println(climbStairs(10));
        System.out.println(dp2(10));
    }


    public static int climbStairs(int n) {
        //base case
        int[] arr = new int[n + 1];
        return dp(arr, n);
    }
    //自上而下
    public static int dp(int[] arr, int n) {
        //base case
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = dp(arr, n - 1) + dp(arr, n - 2);
        return arr[n];
    }

    //自下而上
    public static int dp2(int n) {
        //base case
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int m = 1;
        int k = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = m + k;
            m = k;
            k = temp;
        }
        return temp;
    }
}
