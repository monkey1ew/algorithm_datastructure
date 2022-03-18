package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2129. 将标题首字母大写
 */
public class Solution_2129 {

    public static void main(String[] args) {

        String title = "i lOve leetcode";
        capitalizeTitle(title);
    }

    public static String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String str : strings) {
            int len = str.length();
            if (len == 1 || len == 2) {
                sb.append(str.toLowerCase() + " ");
                continue;
            }
            sb.append(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase() + " ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
