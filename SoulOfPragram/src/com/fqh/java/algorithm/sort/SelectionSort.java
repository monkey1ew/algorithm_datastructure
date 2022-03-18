package com.fqh.java.algorithm.sort;
import java.util.Arrays;


/**
 * @author 比奇堡海滩
 * @version 1.0
 * 选择排序
 */
@SuppressWarnings("all")
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1, 7, 43};

        selectSort(arr);
        System.out.println("排序后.........." );
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr){

        //嵌套一个循环
        //时间复杂度 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            //第一轮
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { //说明假定的最小值 并不是最小值
                    min = arr[j]; //重置min
                    minIndex = j; //重置minIndex
                }
            }
            //将最小值, 放在arr[i], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
