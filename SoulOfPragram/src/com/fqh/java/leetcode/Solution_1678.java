package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1678. 设计 Goal 解析器
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 */
public class Solution_1678 {

    public static void main(String[] args) {

        String command = "G()(al)";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        String replace = command.replace("()", "o");
        System.out.println(replace);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < replace.length(); i++) {
            if (replace.charAt(i) == '(' || replace.charAt(i) == ')') {
                continue;
            }
            sb.append(replace.charAt(i));
        }
        return sb.toString();
    }
}
