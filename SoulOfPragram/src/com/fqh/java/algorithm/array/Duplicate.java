package com.fqh.java.algorithm.array;

/**
 * @author 海盗狗
 * @version 1.0
 * 去除数组的重复元素
 */
public class Duplicate {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护[0——slow]无重复元素
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 长度为index + 1
        return slow + 1;
    }
}
