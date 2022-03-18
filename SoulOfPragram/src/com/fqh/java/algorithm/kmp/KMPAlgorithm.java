package com.fqh.java.algorithm.kmp;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 686. 重复叠加字符串匹配
 */
public class KMPAlgorithm {

    public static void main(String[] args) {

        String str1 = "abababab";
        String str2 = "a";
//        String str2 = "BBC";
//        int[] next = kmpNext("GTGTGCF");
//        System.out.println("next = " + Arrays.toString(next));
        int index = kmp(str1, str2);
        System.out.println("index = " + index);
//        System.out.println(Arrays.toString(kmpNext("")));
    }

    //kmp搜索算法
    /**
     * @param str1  主串
     * @param str2 模式串
     * @return 返回str2首次出现的index
     */
    public static int kmp(String str1, String str2) {
        int[] next = kmpNext(str2);
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            //遇到坏字符时, 查询next数组并改变模式串的起点
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) { //找到
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取到一个字符串(子串)的部分匹配表
    public static int[] kmpNext(String dest) {
        //创建next数组, 保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串长度为1, 部分匹配值为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //dest.charAt(i) != dest.charAt(j) -> 重next[j - 1]获取新的j
            //直到发现  dest.charAt(i) == dest.charAt(j)才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            //dest.charAt(i) == dest.charAt(j) -> 部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
