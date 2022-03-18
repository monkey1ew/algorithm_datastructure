package com.fqh.java.algorithm.sort;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
@SuppressWarnings("all")
public class SortTest {
    public static void main(String[] args) {


//        int[] arr = {5, 2, 67, 21, 11, -241, 270, -8, 0};
        int[] arr = {53, 3, 542, 748, -14, -214};

//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);

//        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);
//        radixSort(arr);
        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
    //选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int insertValue = arr[i];

            for (; (j >= 0) && (insertValue < arr[j]); j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = insertValue;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int insertValue = arr[j];
                if(arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && insertValue < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = insertValue;
            }
        }
    }

    //快排
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }

            if (l >= r){
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
        int t = 0;
        int[] temp = new int[arr.length];

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
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    //基数排序
    public static void radixSort(int[] arr) {
        int max = arr[0];
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int maxLength = (max + "").length();
        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] -= min;
                max -= min;
            }
        }
        int[][] buckets = new int[10][arr.length];
        int[] bucketElements = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int destBucket = arr[j] / n % 10;
                buckets[destBucket][bucketElements[destBucket]] = arr[j];
                bucketElements[destBucket]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElements.length; k++) {
                if (bucketElements[k] != 0) {
                    for (int l = 0; l < bucketElements[k]; l++) {
                        arr[index++] = buckets[k][l];
                    }
                }
                bucketElements[k] = 0;
            }
        }
        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] += min;
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}