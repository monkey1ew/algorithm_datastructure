package com.fqh.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 1629. 按键持续时间最长的键
 * 输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * 输出："c"
 * 解释：按键顺序和持续时间如下：
 * 按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
 * 按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
 * 按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
 * 按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
 * 按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
 * 'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
 */
public class Solution_1629 {

    public static void main(String[] args) {
        int[] releaseTimes = {9 ,29, 49, 50};
        String keyPressed = "cbcd";
        slowestKey(releaseTimes, keyPressed);
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < releaseTimes.length; i++) {
            if (i + 1 < releaseTimes.length) {
                map.put(keysPressed.charAt(i + 1), releaseTimes[i + 1] - releaseTimes[i]);
            }
        }
        System.out.println(map);

        return '1';
    }
}
