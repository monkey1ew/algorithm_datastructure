package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1385. 两个数组间的距离值
 */
public class Solution_1385 {

    public static void main(String[] args) {

        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {-4, -3, 6, 10, 20, 30};
        int d = 3;
        findTheDistanceValue(arr1, arr2, d);
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
