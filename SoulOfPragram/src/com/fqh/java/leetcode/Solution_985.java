package com.fqh.java.leetcode;

import java.util.AbstractQueue;
import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 985. 查询后的偶数和
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 */
public class Solution_985 {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

        sumEvenAfterQueries(A, queries);
    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int[] link : queries) {
            int v = link[0];
            int index = link[1];
            nums[index] = nums[index] + v;
            ans[j++] = sum(nums);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
