package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1672. 最富有客户的资产总量
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 */
public class Solution_1672 {

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        maximumWealth(accounts);
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] link : accounts) {
            int aCount = 0;
            for (int i = 0; i < link.length; i++) {
                aCount += link[i];
            }
            max = Math.max(max, aCount);
        }
        System.out.println(max);
        return max;
    }
}
