package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2124. 检查是否所有 A 都在 B 之前
 * 输入：s = "aaabbb"
 * 输出：true
 * 解释：
 * 'a' 位于下标 0、1 和 2 ；而 'b' 位于下标 3、4 和 5 。
 * 因此，每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 */
public class Solution_2124 {

    public static void main(String[] args) {

        String s = "a";
        System.out.println(checkString(s));
    }

    public static boolean checkString(String s) {
        int firstIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                firstIndex = i;
                break;
            }
        }
        if(firstIndex == 0 && s.charAt(0) == 'a') {
            return true;
        }
        for (int i = firstIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }
}
