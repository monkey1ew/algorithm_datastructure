package com.fqh.java.algorithm.handsort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 */
@SuppressWarnings("all")
public class AllSort {

    public static void main(String[] args) {

        int[] arr = {3, -9, 11, 23, 657, 0, -1};

//        selectSort(arr);
//        insertSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int j = i - 1;
            for (; (j >= 0) && (insertValue < arr[i]); j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = insertValue;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int insertValue = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && insertValue < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = insertValue;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int povit = arr[left + (right - left) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < povit) {
                l += 1;
            }
            while (arr[r] > povit) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == povit) {
                r -= 1;
            }
            if (arr[r] == povit) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    //归并排序
    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[arr.length];
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    //计数排序
    public static void radixSort(int[] arr) {

    }
}
