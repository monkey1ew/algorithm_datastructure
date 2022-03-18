package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * LCP 06. 拿硬币
 * 输入：[4,2,1]
 * 输出：4
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 */
public class LCP_06 {

    public static void main(String[] args) {
        int[] coins = {4, 2, 1};
        minCount(coins);
    }

    public static int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > 2) {
                if (coins[i] % 2 == 0) {
                    count += coins[i] / 2;
                }else {
                    count += coins[i] / 2 + coins[i] % 2;
                }
                continue;
            }
            count += 1;
        }
//        System.out.println(count);
        return count;
    }
}
