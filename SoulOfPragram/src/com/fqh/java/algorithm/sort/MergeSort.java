package com.fqh.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("归并排序后= " + Arrays.toString(arr));
    }

    //分的过程
    public static void mergeSort(int[] arr, int left, int right){
        if (left < right){
            int mid = (left + right) / 2; //拿到中间的索引
            //向左递归分解
            mergeSort(arr, left, mid);
            //向右递归分解
            mergeSort(arr, mid + 1, right);
            //每分解就合并
            merge(arr, left, mid, right);
        }
    }

    //合并的方法
    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     */
    public static void merge(int[] arr, int left, int mid, int right){
        int i = left; //初始化i; 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int t = 0;  // 指向temp数组的当前索引
        int[] temp = new int[arr.length]; //归并需要额外的空间

        //1.
        //先把左右两边(有序)的数据填充到temp数组
        //直到左右两边的有序序列有一边处理完毕为止
        while (i <= mid && j <= right){ //继续
            //如果 左边的有序序列的当前元素 <= 右边有序序列的当前元素
            //即 将左边的当前元素 拷贝到temp数组, 后移 t , i !!!
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];

            }else {
                //将右边的元素填充到temp
                temp[t++] = arr[j++];
            }
        }

        //2.
        //把有剩余数据的一边的元素依次填充到temp
        while (i <= mid){ //说明左边的有序序列还有剩余元素
            //全部填充到temp
            temp[t++] = arr[i++];
        }

        while (j <= right){//右边还有
            //填充temp
            temp[t++] = arr[j++];
        }

        //3.
        //将temp数组的元素 拷贝到arr
        //不是每次都拷贝8个
        t = 0;
        int tempLeft = left; //第一次tempLeft = 0; right = 1//
        System.out.println("tempLeft =" + tempLeft + "  right = " + right);
        while (tempLeft <= right){
            arr[tempLeft++] = temp[t++];
        }
    }
}
