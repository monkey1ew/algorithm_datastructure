package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 496. 下一个更大元素 I
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 */
public class Solution_496 {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        nextGreaterElement(nums1, nums2);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int element : nums1) {
            queue.offer(element);
        }
        int index = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < nums2.length; i++) {
                if (n == nums2[i]) {
                    index = i;
                    for (int j = index; j < nums2.length; j++) {
                        if (nums2[j] > n) {
                            list.add(nums2[j]);
//                            index = 0;
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
//                        index = 0;
                        flag = false;
                        break;
                    }
                    list.add(-1);
                }
            }

        }
        System.out.println(list);
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(ints));
        return ints;
    }
}
