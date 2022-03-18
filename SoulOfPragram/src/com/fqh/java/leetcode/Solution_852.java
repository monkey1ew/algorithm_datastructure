package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 852. 山脉数组的峰顶索引
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 */
public class Solution_852 {

    public static void main(String[] args) {
        int[] arr = {24, 69, 100, 99, 79};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;

    }

}
