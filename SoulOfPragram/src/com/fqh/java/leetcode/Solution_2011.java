package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2011. 执行操作后的变量值
 * 输入：operations = ["--X","X++","X++"]
 * 输出：1
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * --X：X 减 1 ，X =  0 - 1 = -1
 * X++：X 加 1 ，X = -1 + 1 =  0
 * X++：X 加 1 ，X =  0 + 1 =  1
 */
public class Solution_2011 {

    public static void main(String[] args) {

        String[] operations = {"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String link : operations) {
            for (int i = 0; i < link.length(); i++) {
                if (link.charAt(i) == '-') {
                    result--;
                    break;
                } else if (link.charAt(i) == '+') {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
