package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1688. 比赛中的配对次数
 * 输入：n = 7
 * 输出：6
 * 解释：比赛详情：
 * - 第 1 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * - 第 2 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * - 第 3 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * 总配对次数 = 3 + 2 + 1 = 6
 */
public class Solution_1688 {

    public static void main(String[] args) {
        int n = 7;
        numberOfMatches(n);
    }

    public static int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += n / 2;
            n -= n / 2;

        }
        return res;
    }
}
