package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 703. 数据流中的第 K 大元素
 */
public class Solution_703 {

    public static void main(String[] args) {

        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

class KthLargest {
    Queue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for(int i: nums) {
            add(i);
        }
    }

    public int add(int val) {
        if(queue.size() < k) {
            queue.offer(val);

        } else if(queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

//    public void quickSort(int[] arr, int left, int right) {
//        int l = left;
//        int r = right;
//        int pivot = arr[left + (right - left) / 2];
//        int temp = 0;
//        while (l < r) {
//            while (arr[l] < pivot) {
//                l += 1;
//            }
//            while (arr[r] > pivot) {
//                r += 1;
//            }
//            if (l >= r) {
//                break;
//            }
//            temp = arr[l];
//            arr[l] = arr[r];
//            arr[r] = temp;
//            if (arr[l] == pivot) {
//                r -= 1;
//            }
//            if (arr[r] == pivot) {
//                l += 1;
//            }
//        }
//        if (l == r) {
//            l += 1;
//            r -= 1;
//        }
//        if (left < r) {
//            quickSort(arr, left, r);
//        }
//        if (right > l) {
//            quickSort(arr, l, right);
//        }
//    }
}

