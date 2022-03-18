package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 1720. 解码异或后的数组
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 */
public class Solution_1720 {

    public static void main(String[] args) {
        int[] encoded = {1, 2, 3};
        int first = 1;
        decode(encoded, 1);
        System.out.println(encoded[0] ^ 0);
        System.out.println(encoded[0] ^ 2);
    }

    public static int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ans[i + 1] = encoded[0] ^ i;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
