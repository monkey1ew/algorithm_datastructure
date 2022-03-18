package com.fqh.java.algorithm.search;

import java.util.ArrayList;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
@SuppressWarnings("all")
public class SearchTest {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};


        ArrayList<Integer> arrayList = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(arrayList);
//        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 1));
    }
    //针对多个相同的数的二分查找
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int target){
        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if (left > right){
            return new ArrayList<Integer>();
        }

        if (target < midValue){
            return binarySearch(arr, left, midIndex - 1, target);
        }else if (target > midValue){
            return binarySearch(arr, midIndex + 1, right, target);
        }else {
            ArrayList<Integer> indexList = new ArrayList<>();
            //向mid 索引值的左边扫描， 将所有满足1000 的元素下标，加入到ArrayList
            int temp = midIndex - 1;
            while (true) {
                if (temp < 0 || arr[temp] != target) {
                    break;
                }
                //添加并左移
                indexList.add(temp--);
            }
            indexList.add(midIndex);
            //向mid 索引值的右边扫描， 将所有满足1000 的元素下标，加入到ArrayList
            temp = midIndex + 1;
            while (true){
                if (temp > right || arr[temp] != target){
                    break;
                }
                //添加并右移动
                indexList.add(temp++);
            }
            return indexList;
        }
    }

    //插值查找
    public static int insertValueSearch(int[] arr, int left, int right, int target){
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (left > right){
            return -1;
        }

        if (target < midValue){
            return insertValueSearch(arr, left, mid - 1, target);
        }else if (target > midValue){
            return insertValueSearch(arr, mid + 1,right, target);
        }else {
            return mid;
        }
    }
}
