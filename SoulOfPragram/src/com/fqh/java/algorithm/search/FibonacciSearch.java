package com.fqh.java.algorithm.search;

import java.util.Arrays;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int index = fibSearch(arr, 10);
        System.out.println("index = " + index);
    }

    //构建斐波那契数列 mid = low + F(k - 1) -1
    //非递归方式
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找算法
    /** 使用非递归方式
     * @param arr 数组
     * @param key 需要查找的数
     * @return 返回对应下标
     */
    public static int fibSearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //表示斐波那契分割数值对应的下标
        int mid = 0; //存放mid值
        int f[] = fib(); //获取fb数列
        //获取到斐波那契分割数的下标
        while (high > f[k] - 1){
            k++;
        }
        //f[k] 值可能大于 a的长度, 构建新的数组指向 arr
        int[] temp = Arrays.copyOf(arr, f[k]);
        //需要使用a数组最后的数填充 temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while循环处理，找到 key
        while (low <= high){
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]){ //说明我们应该继续向数组的左边查找
                high = mid - 1;
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k - 1] + f[k - 2]
                //前面有 f[k - 1]个元素, 可以继续拆分 f[k - 1] = f[k - 2] + f[k - 3]
                // 在f[k - 1] 的前面继续查找
                k--;
            }else if (key > temp[mid]){
                low = mid + 1;
                //2. f[k] = f[k - 1] + f[k - 2];
                //3. f[k - 1] = f[k - 2] + f[k - 3]
                //4.在 f[k - 2] 的前面进行查找 k -= 2
                //5. mid = f[k - 1 - 2] - 1
                k -= 2;
            }else {
                //需要确定返回的是哪个下标
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
