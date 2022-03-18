package com.fqh.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 47, 0, 23, -567, 70, -11};
        int[] arr2 = {-9, 78, 47, 0, 23, -567};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中间值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量, 交换时使用
        //while循环将比pivot值小的放在 左边
        //比pivot大的值放在，右边
        while (l < r){
            //在pivot的左边一直找, 找到大于等于pivot值,才退出
            while (arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找, 找到小于pivot值,才退出
            while (arr[r] > pivot){
                r -= 1;
            }
            //如果l >= r成立 说明pivot左右两边的值
            // 小于等于pivot <---- pivot ----> 大于等于pivot
            if (l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后, 发现arr[l] == pivot值 r--, 前移
            if (arr[l] == pivot){
                r -= 1;
            }

            //如果交换完后, 发现arr[r] == pivot值 l++, 后移
            if (arr[r] == pivot){
                l += 1;
            }
        }

        //如果l == r, 必须让l++, r--, 否则StackOverFlowException
        if(l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr, left, r);
        }

        if (right > l){
            quickSort(arr, l, right);
        }

    }
}