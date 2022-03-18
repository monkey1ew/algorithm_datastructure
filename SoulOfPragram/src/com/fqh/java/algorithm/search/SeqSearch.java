package com.fqh.java.algorithm.search;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 线性查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1){
            System.out.println("没有查找到" + index);
        }else {
            System.out.println("找到下标为" + index);
        }
    }

    /**
     * 实现的是找到一个满足条件的值就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value){
        //线性查找----->逐一对比
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return value;
            }
        }
        return -1;
    }
}
