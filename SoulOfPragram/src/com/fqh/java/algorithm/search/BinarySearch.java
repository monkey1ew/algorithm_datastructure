package com.fqh.java.algorithm.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 二分查找要求该数组是有序的
 */
@SuppressWarnings("all")
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> resIndexList = binarySearch(arr, 0, arr.length -1 , 1000);
        System.out.println("resIndex =" + resIndexList);
        
    }

    //二分查找法
    /**
     * @param arr 有序数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 目标值
     * @return  返回下标 or -1
     */
//    public static int binarySearch(int[] arr, int left, int right, int findVal){
//        int mid = (left + left) / 2;
//        int midVal = arr[mid];
//
//        //当left > right 时，说明递归了整个数组，也没有找到
//        if (left > right){
//            return -1;
//        }
//
//        if (findVal > midVal){ //向右递归
//            return binarySearch(arr, mid + 1, right, findVal);
//        }else if (findVal < midVal){ // 左递归
//            return binarySearch(arr, left, mid - 1, findVal);
//        }else {
//            return mid;
//        }
//    }

    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findVal){
        System.out.println("hello-");
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        //当left > right 时，说明递归了整个数组，也没有找到
        if (left > right){
            return new ArrayList<Integer>();
        }

        if (findVal > midVal){ //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){ // 左递归
            return binarySearch(arr, left, mid - 1, findVal);
        }else {
            /**
             * 二分查找多个相同的值，并返回所有的索引
             * 1. 在找到mid 索引值，不要马上返回
             * 2. 向mid 索引值的左边扫描， 将所有满足1000 的元素下标，加入到ArrayList
             * 3. 向mid 索引值的右边扫描， 将所有满足1000 的元素下标，加入到ArrayList
             */
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向mid 索引值的左边扫描， 将所有满足1000 的元素下标，加入到ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //添加并左移
                resIndexList.add(temp--);
            }
            resIndexList.add(mid);
            //向mid 索引值的右边扫描， 将所有满足1000 的元素下标，加入到ArrayList
            temp = mid + 1;
            while (true){
                if (temp > right || arr[temp] != findVal){
                    break;
                }
                //添加并右移动
                resIndexList.add(temp++);
            }
            return resIndexList;
        }
    }
}
