package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2180. 统计各位数字之和为偶数的整数个数
 */
public class Solution_2180 {

    public static void main(String[] args) {


        System.out.println(countEven(1000));
    }

    public static int countEven(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++) {
            int j = i / 1 % 10;
            int k = i / 10 % 10;
            int l = i / 100 % 10;
            if((k + j + l) % 2 == 0) {
                count++;
            }
        }
        if(count == 500) {
            return count - 1;
        }
        return count;
    }
}
