package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1281. 整数的各位积和之差
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 */
public class Solution_1281 {

    public static void main(String[] args) {

//        System.out.println(234 % 1000 / 100); //2
//        System.out.println(234 % 100 / 10); //3
//        System.out.println(234 % 10); //4
        int n = 4421;
        System.out.println(subtractProductAndSum(n));

        System.out.println(n % 10);
        n = n / 10;
        System.out.println(n % 10);
        n = n / 10;
        System.out.println(n % 10);
        n = n / 10;
        System.out.println(n % 10);
    }

    public static int subtractProductAndSum(int n) {
        int multiple = 1;
        int sum = 0;
        while (n != 0) {
            multiple *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return multiple - sum;
    }
}
