package com.fqh.java.algorithm.kmp;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        //暴力匹配
        String str1 = "aabbbaaabcccb";
        String str2 = "aaabc";
        System.out.println(violenceMatch(str1, str2));
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0; //i -> str1
        int j = 0; //j -> str2
        while (i < s1Len && j < s2Len) { //保证不越界
            if (s1[i] == s2[j]) { //匹配成功
                i++;
                j++;
            }else {
                //如果匹配失败, i = i - (j - 1): j = 0
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        return j == s2Len ? i - j : -1;
    }
}
