package com.fqh.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);

//
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); //生成[0, 8000000]数
//        }
//
//        long start = System.currentTimeMillis();
//
//        shellSort2(arr);
//
//        long end = System.currentTimeMillis();
//        System.out.println("排序耗时=" + (end - start));
    }

    //逐步推导 希尔排序
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        //分析得到规律, 循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //希尔排序的第一轮
            //因为第一轮排序是将10个数据分成5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共有 5组,每组两个元素), 步长5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于 + 步长后的那个元素说,明需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序"+ (++count) + "轮后=" + Arrays.toString(arr));
        }


//        //希尔排序的第二轮
//        //因为第二轮排序是将10个数据分成5/2组 = 2组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素(共有 5组,每组两个元素), 步长5
//            for (int j = i - 2; j >= 0 ; j -= 2) {
//                //如果当前元素大于 + 步长后的那个元素说明需要交换
//                if (arr[j] > arr[j + 2]){
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序二轮后=" + Arrays.toString(arr));
//
//
//        //希尔排序的第三轮
//        //因为第二轮排序是将10个数据分成5/2组 = 2/2组 = 1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素(共有 5组,每组两个元素), 步长5
//            for (int j = i - 1; j >= 0 ; j -= 1) {
//                //如果当前元素大于 + 步长后的那个元素说明需要交换
//                if (arr[j] > arr[j + 1]){
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序三轮后=" + Arrays.toString(arr));
    }

    //交换式的希尔排序------->移位式希尔
    public static void shellSort2(int[] arr) {

        //增量gap, 逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从gap个元素开始逐个对所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int insertValue = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && insertValue < arr[j - gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后,就给insertValue找到插入的位置
                    arr[j] = insertValue;
                }
            }
        }
    }




}
