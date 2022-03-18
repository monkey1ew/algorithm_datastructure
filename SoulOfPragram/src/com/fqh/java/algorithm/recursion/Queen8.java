package com.fqh.java.algorithm.recursion;

import javax.management.Query;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array,保存皇后存放的位置的结果, arr={0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        //Test
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法", count);
    }


    //编写方法,放置第N个皇后
    //注意: check 是每一次递归时,都有一层check都有for循环
    private void check(int n){
        if(n == max){ //n = 8, 已经放好了第8个
            print();
            return;
        }

        //依次放入皇后, 判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n ,放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到 i列时,是否冲突
            if(judge(n)) { //不冲突
                //接着放n+1个皇后
                check(n + 1);
            }
            //如果冲突就继续执行 array[n] = i; 将第n个皇后放在本行后一个位置

        }
    }

    //当我们放置第n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第 n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //1. array[i] == array[n] 判断第 n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n - 1) == Math.abs(array[n] - array[i]) 第n个皇后是否和第i个皇后在同一斜线
            if(array[i] == array[n] || Math.abs(n - 1) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    //写一个方法, 可以将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
