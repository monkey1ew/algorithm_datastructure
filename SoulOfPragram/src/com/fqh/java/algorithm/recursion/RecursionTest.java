package com.fqh.java.algorithm.recursion;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 递归(回溯算法)
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
    }

    //
    public static void test(int n){
        if(n > 2){
            test(n - 1);
        }
        System.out.println("n------>" + n);
    }
}
