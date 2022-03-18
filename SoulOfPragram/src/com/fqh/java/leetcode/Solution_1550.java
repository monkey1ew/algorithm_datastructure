package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1550. 存在连续三个奇数的数组
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 */
public class Solution_1550 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(threeConsecutiveOdds(arr));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n % 2 == 1) {
                count++;
            }else {
                count = 0; //重置
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }
}
