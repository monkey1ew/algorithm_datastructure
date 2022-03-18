package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1221. 分割平衡字符串
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 */
public class Solution_1221 {

    public static void main(String[] args) {

        String s = "RLRRLLRLRL";
        balancedStringSplit(s);
    }

    public static int balancedStringSplit(String s) {
        int match = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                match++;
            }else if (s.charAt(i) == 'L') {
                match--;
            }
            if (match == 0) {
                ans += 1;
            }
        }
//        System.out.println(ans);
        return ans;
    }
}
