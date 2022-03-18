package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 344. 反转字符串
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Solution_344 {

    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
//        char temp = ',';
//        temp = s[0];
//        System.out.println(temp);
    }

    public static void reverseString(char[] s) {
        char temp = '0';
        int i = 0;
        int j = s.length - 1;
        while (true) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
            if (i == j || i > j) {
                break;
            }
        }
        for(char c : s) {
            System.out.println(c);
        }
    }
}
