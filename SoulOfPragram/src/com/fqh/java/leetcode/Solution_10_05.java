package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 10.05. 稀疏数组搜索
 * 稀疏数组搜索。
 * 有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 */
public class Solution_10_05 {

    public static void main(String[] args) {

    }

    public static int findString(String[] words, String s) {

        return binarySearch(words, 0,words.length - 1, s);
    }

    public static int binarySearch(String[] words, int left, int right, String s) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return -1;
        }
        if (s.chars().sum() < words[mid].chars().sum()) {
            return binarySearch(words, left, mid - 1, s);
        }
        if (s.chars().sum() > words[mid].chars().sum()) {
            return binarySearch(words, mid + 1, right, s);
        }else {
            return mid;
        }
    }
}
