package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1313. 解压缩编码列表
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 */
public class Solution_1313 {


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        decompressRLElist(nums);
    }

    public static int[] decompressRLElist(int[] nums) {
        int j = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                len += nums[i];
            }
        }
        int[] ans = new int[len];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                int count = nums[i - 1];
                while (count > 0) {
                    ans[j++] = nums[i];
                    count--;
                }
            }
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
