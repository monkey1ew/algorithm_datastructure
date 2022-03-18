package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 832. 翻转图像
 */
public class Solution_832 {

    public static void main(String[] args) {

        int[][] image = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 0}
        };
        flipAndInvertImage(image);
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for(int[] link : image) {
            reservs(link);
        }
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                if(image[i][j] == 0) {
                    image[i][j] = 1;
                }else {
                    image[i][j] = 0;
                }
            }
        }
        return image;
    }

    public static void reservs(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(j > i) {
            int temp = 0;
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }
}
