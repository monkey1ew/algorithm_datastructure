package com.fqh.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, -14, 214};
        radixSort(arr);
        System.out.println("基数排序后=" + Arrays.toString(arr));
    }

    //基数排序
    public static void radixSort(int[] arr) {

        //根据推导，最终基数排序代码

        //1.得到数组中最大的位数
        int max = arr[0];   //假定第一个就是最大数
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if(arr[i]<min) {
                min = arr[i];//找到负数最小值
            }
        }
		if(min<0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] -= min;
                max -= min;
            }
        }
        //得到最大数 是几位数
        int maxLength = (max + "").length();

        //第一轮, 针对每个元素的个数

        //定义一个二维数组, 表示10个桶, 每一个桶表示一个 一维数组
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候,数据溢出，则每个桶大小定为 arr.length
        //3.基数排序 ---------------->空间换时间
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据, 定义一个一维数组来记录各个桶每次放入的数据个数
        //bucketElementCounts记录的就是  bucket[0] 桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        //使用循环处理代码
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的位值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一个桶并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶的第k个桶(一维数组)
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i + 1轮处理后需要将每一个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
        if(min<0) {
            for(int mi = 0;mi<arr.length;mi++) {
                arr[mi] += min;
            }
        }

//        //第一轮
//        for (int j = 0; j < arr.length; j++){
//            //取出每个元素的个位
//            int digitOfElement = arr[j] / 1 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
//        int index = 0;
//        //遍历每一个桶并将桶中的数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据才放入到原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶的第k个桶(一维数组)
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            //第一轮处理后需要将每一个bucketElementCounts[k] = 0
//            bucketElementCounts[k] = 0;
//        }
//
//        System.out.println("第一轮对个数的排序处理 :" + Arrays.toString(arr));
//
//
//        //第一轮
//        for (int j = 0; j < arr.length; j++){
//            //取出每个元素的个位
//            int digitOfElement = arr[j] / 1 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
//        int index = 0;
//        //遍历每一个桶并将桶中的数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据才放入到原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶的第k个桶(一维数组)
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            //第一轮处理后需要将每一个bucketElementCounts[k] = 0
//            bucketElementCounts[k] = 0;
//        }
//
//        System.out.println("第一轮对个数的排序处理 :" + Arrays.toString(arr));
//
//        //====================================================
//        //第二轮
//        for (int j = 0; j < arr.length; j++){
//            //取出每个元素的个位
//            int digitOfElement = arr[j] /10 % 10;  //748 / 10 => 78 % 10
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
//        index = 0;
//        //遍历每一个桶并将桶中的数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据才放入到原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶的第k个桶(一维数组)
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第二轮对个数的排序处理 :" + Arrays.toString(arr));
//
//
//        //=========================================
//        //第三轮
//        for (int j = 0; j < arr.length; j++){
//            //取出每个元素的个位
//            int digitOfElement = arr[j] /100 % 10;  //748 / 100 ==> 7
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
//        index = 0;
//        //遍历每一个桶并将桶中的数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据才放入到原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶的第k个桶(一维数组)
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[k][l];
//                }
//            }
//        }
//        System.out.println("第三轮对个数的排序处理 :" + Arrays.toString(arr));
//    }
    }
}
