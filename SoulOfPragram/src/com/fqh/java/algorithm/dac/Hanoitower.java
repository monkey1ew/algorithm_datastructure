package com.fqh.java.algorithm.dac;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    //分治算法
    public static void hanoiTower(int num, char a, char b, char c) {
        //只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        }else {
            //如果n >= 2, 分治成, 最下面的一个盘 : 上面的所有盘
            //1. A -> C -> B, 借助 C 塔
            hanoiTower(num - 1, a, c, b);
            //2. 最下边的盘 A -> C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 将 B -> A -> C, 借助 A 塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
