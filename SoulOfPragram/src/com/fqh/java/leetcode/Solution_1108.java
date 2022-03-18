package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1108. IP 地址无效化
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 */
public class Solution_1108 {

    public static void main(String[] args) {

        String address = "1.1.1.1";
        defangIPaddr(address);
    }

    public static String defangIPaddr(String address) {

        String replace = address.replace(".", "[.]");
//        System.out.println(replace);
        return replace;
    }
}
