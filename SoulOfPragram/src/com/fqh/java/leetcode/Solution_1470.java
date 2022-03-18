package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1470. 重新排列数组
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1470 {

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        shuffle(nums, n);
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && i % 2 != 0) {
                ans[i] = nums[n++];
                continue;
            }
            ans[i] = nums[j++];
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
