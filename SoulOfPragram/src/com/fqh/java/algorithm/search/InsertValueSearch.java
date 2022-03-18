package com.fqh.java.algorithm.search;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 插值查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int index = insertValueSearch(arr, 0, arr.length - 1, 67);
        System.out.println("index = "+ index);



    }

    //插值查找
    public static int insertValueSearch(int[] arr, int left, int right, int target){
        //要求数组是有序的
        //target < arr[0] || target > arr[arr.length - 1] 优化 + 防止mid越界
        System.out.println("hello---");
        if (left > right || target < arr[0] || target > arr[arr.length - 1]){
            return -1;
        }

        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (target > midValue){ //说明应该向右递归查找
            return insertValueSearch(arr, mid + 1, right, target);
        }else if (target < midValue){ //说明应该向左递归查找
            return insertValueSearch(arr, left, mid - 1, target);
        }else {
            return mid;
        }
    }
}
