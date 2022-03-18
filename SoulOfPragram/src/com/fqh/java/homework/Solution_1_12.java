package com.fqh.java.homework;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_1_12 {

    public static void main(String[] args) {

        int n = 20;
//        answer01(n);
//        answer02(n);
//        answer03(n);
//        answer04(n);
        answer05(n);
    }

    public static void answer01(int n) {
//        记录算法执行的次数
        int count = 0;
        int i = 1, k = 0;
        while (i < n - 1) {
            k += 10 * k;
            i += 1;
            count++;
        }
        System.out.println("answer01算法执行的次数 : " + count);
    }

    public static void answer02(int n) {
        int count = 0;
        int i = 1, k = 0;
        do {
            k += 10 * i;
            i += 1;
            count++;
        }while (i != n);
        System.out.println("answer02算法执行的次数 : " + count);
    }

    public static void answer03(int n) {
        int count = 0;
        int i = 1, j = 1;
        while (i <= n && j <= n) {
            i +=1;
            j +=1;
            count++;
        }
        System.out.println("answer03算法执行的次数 : " + count);
    }

    public static void answer04(int n) {
        int count = 0;
        int x = n, y = 0;
        while (x >= (y + 1)*(y + 1)) {
            y++;
            count++;
        }
        System.out.println("answer04算法执行的次数 : " + count);
    }

    public static void answer05(int n) {
        int leve1 = 0;
        int leve2 = 0;
        int leve3 = 0;
        int leve4 = 0;
        int i, j, k, x = 0;
        for (i = 0; i < n; i++) {
            leve1++;
            for (j = 0; j < i; j++) {
                leve2++;
                for (k = 0; k < j; k++) {
                    leve3++;
                    x +=1;
                }
            }
        }
        System.out.println("answer05算法执行的次数 : " + leve1 +" " +  leve2 + " " + leve3);
    }
}
