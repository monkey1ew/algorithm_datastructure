package com.fqh.java.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 插入排序
 */
@SuppressWarnings("all")
public class InsertSort {

    public static void main(String[] args) {


        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成[0, 8000000]数
        }

        long start = System.currentTimeMillis();


        insertSort(arr);

        long end = System.currentTimeMillis();
        System.out.println("排序耗时=" + (end - start));

    }



    //插入排序
    public static void insertSort(int[] arr){
        //逐步推导---->
        //第1轮 {101, 34, 119, 1} ==> {34, 101, 119, 1};

        //定义待插入的
//        int insertValue = arr[1];
//        int insertIndex = 1 - 1 ; //即arr[1] 的前面这个数的下标

        //给insertValue 找到插入的位置
        //1. insertIndex >= 0 保证在给insertValue插入位置时,不越界
        //2. insertValue < arr[insertIndex] 待插入的数, 还没有找到插入位置
        //3. 就需要将insertIndex 后移

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int j = i - 1 ;
            //从右向左比较元素的同时, 进行元素复制
            for (; (j >= 0) && (insertValue < arr[j]); j--) {
                arr[j + 1] = arr[j];
            }

            //insertValue的值插入适当位置
            arr[j + 1] = insertValue;
        }
    }
}

