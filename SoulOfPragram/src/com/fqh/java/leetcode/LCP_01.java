package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * LCP 01. 猜数字
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 */
public class LCP_01 {

    public static void main(String[] args) {
        int[] guess = {2, 2, 3};
        int[] answer = {3, 2, 1};

        System.out.println(game(guess, answer));
    }


    public static int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < answer.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
