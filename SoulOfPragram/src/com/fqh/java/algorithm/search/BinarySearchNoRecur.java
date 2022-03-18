package com.fqh.java.algorithm.search;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        System.out.println("index = " + binarySearch(arr, 8));
    }

    //二分查找的非递归实现
    /**
     * @param arr 待查找的数组
     * @param target 目标数
     * @return 返回对应下标
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                right = mid - 1; //向左查找
            }else if (arr[mid] < target) {
                left = mid + 1; //向右查找
            }
        }
        return -1;
    }
}
