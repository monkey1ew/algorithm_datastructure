package com.fqh.java.algorithm.dp;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 4, 3}; //物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值 val[i] -> v[i]
        int m = 4; //背包的容量
        int n = val.length; //物品的个数

        //创建二维数组
        //v[i][j] -> 表示在前i个物品中能够装入容量为j的背包的最大价值
        int[][] dp = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; //将第一列设置为0
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0; //将第一行设置为0
        }
        //dp处理
        for (int i = 1; i < dp.length; i++) { //不处理第一行 [0 ,0 ,0 ....]
            for (int j = 1; j < dp[0].length; j++) { //不处理第一列
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
//                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - w[i - 1]]);
                    //记录商品存放到背包的情况
                    if (dp[i - 1][j] < val[i - 1] + dp[i - 1][j - w[i - 1]]) {
                        dp[i][j] = val[i - 1] + dp[i - 1][j - w[i - 1]];
                        //记录
                        path[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        for (int[] link : dp) {
            System.out.println(Arrays.toString(link));
        }
        System.out.println("###################################");
        //输出最后放入的商品
        //输出冗余数据---->
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j] == 1) {
//                    System.out.printf("第%d个商品放入到背包\n", i);
//                }
//            }
//        }
        int i = path.length - 1;    //行的最大下标
        int j = path[0].length - 1; //列的最大下标
        while (i > 0 && j > 0) { //逆向遍历
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1]; //w[i - 1]
            }
            i--;
        }
    }
}
