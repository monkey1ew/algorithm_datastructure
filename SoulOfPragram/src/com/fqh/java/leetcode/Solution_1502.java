package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1502. 判断能否形成等差数列
 */
public class Solution_1502 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4};
        System.out.println(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        int incr = arr[1] - arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                if (incr != arr[i + 1] - arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[left + (right - left) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (l < right) {
            quickSort(arr, l, right);
        }
        if (r > left) {
            quickSort(arr, left, r);
        }
    }
}
