package com.fqh.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序,.,.,.,.,.,");
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次调整" + Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次调整" + Arrays.toString(arr));
        //合并
        //1.将无序数组，做成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("调整后" + Arrays.toString(arr));
        /**
         * 2)将堆顶元素与末尾元素交换, 将最大元素"沉"到数组末尾
         * 3) 重新调整结构, 使其满足堆定义
         */
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    //将一个数组(二叉树), 调整成一个大顶堆
    /** 完成将以 i 对应的非叶子节点的树调整成大顶堆
     * int[] arr = {4, 6, 8, 5, 9};=> i = 1 =>  {4, 9, 8, 5, 6}
     * 再次调用 i = 0; ==> {9, 6, 8, 5, 4}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整, length 在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i]; //取出当前元素的值, 保存在临时变量
        //开始调整
        //1. k = i * 2 + 1 k 是 i结点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]){ //说明左子节点的值 < 右子节点的值
                k++; //k指向右子节点
            }
            if (arr[k] > temp){ //如果子节点 > 父节点
                arr[i] = arr[k]; //把较大的值，赋给当前节点
                i = k; //让i 指向 k ,继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后, 我们已经将以i为父节点的树的最大值,放在了 最顶(局部)
        arr[i] = temp;// 将temp的值放在调整后的位置
    }
}
