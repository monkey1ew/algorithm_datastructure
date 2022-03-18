package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Solution_10 {

    public static void main(String[] args) {
        System.out.println(numWays(48));
    }

    public static int numWays(int n) {
        int[] arr = new int[n + 1];
        return dp(arr, n);
    }

    public static int dp(int[] arr, int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(arr[n] != 0) {
            return arr[n];
        }
        arr[n] = (dp(arr, n - 1) + dp(arr, n - 2)) % 1000000007;
        return arr[n];
    }
}
