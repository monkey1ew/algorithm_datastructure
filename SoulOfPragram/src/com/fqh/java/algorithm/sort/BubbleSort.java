package com.fqh.java.algorithm.sort;
/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int arr[] = {3, 9, -1, 10, -2};

        //时间复杂度 O(n^2)

        //测试冒泡排序的速度, 8w个数据测试
        //创建8w个的随机的数组

//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[800];
        for (int i = 0; i < 800; i++) {
            arr[i] = (int) (Math.random() * 800); //生成[0, 8000000]数
        }

        long start = System.currentTimeMillis();

        bubbleSort(arr);

        long end = System.currentTimeMillis();
        System.out.println("排序耗时=" + (end - start));//排序耗时=10805 10second
    }

    //封装成方法
    public static void bubbleSort(int[] arr){
        //外层for轮数, 内层for进行比较
        int temp = 0; //临时变量
        boolean flag = false; //标识变量, 表示是否进行过交换

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag){ //在一趟排序中一次都没有发生
                break;
            }else {
                flag = false; //重置flag, 进行下次判断;
            }
        }
    }
}
