package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 16.20. T9键盘
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 */
public class Solution_16_20 {

    public static void main(String[] args) {

        String num = "8733";
        String[] words = {"tree", "used"};
        getValidT9Words(num, words);
    }

    public static List<String> getValidT9Words(String num, String[] words) {
        Map<Character,Character> map = new HashMap<>();
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');
        List<String> list = new ArrayList<>();
        boolean flag = true;
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) != num.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(str);
            }
            flag = true;
        }
        System.out.println(list);
        return list;
    }
}
