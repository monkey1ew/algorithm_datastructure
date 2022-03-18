package com.fqh.java.leetcode;

import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 凑零钱
 */
public class Solution_322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


    public static int coinChange(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount == -1) {
            return -1;
        }
        int[] dp = new int[coins.length];

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int sum = Math.min(amount, coinChange(coins, amount - coin));
            if (sum == -1) {
                continue;
            }
            res = Math.min(res, sum + 1);
        }

        System.out.println(res);
        return 0;
    }
}
