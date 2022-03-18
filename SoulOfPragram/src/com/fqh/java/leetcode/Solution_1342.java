package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1342. 将数字变成 0 的操作次数
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 */
public class Solution_1342 {

    public static void main(String[] args) {

        int num = 14;
        numberOfSteps(num);
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
                count++;
            }else {
                num--;
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
