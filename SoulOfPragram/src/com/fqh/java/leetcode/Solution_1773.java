package com.fqh.java.leetcode;

import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1773. 统计匹配检索规则的物品数量
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 *
 */
public class Solution_1773 {

    public static void main(String[] args) {

    }


    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchCount = 0;
        for (List<String> link : items) {
            String type = link.get(0);
            String color = link.get(1);
            String name = link.get(2);
            if (ruleKey.equals("type")) {
                if (type.equals(ruleValue)) {
                    matchCount++;
                }
            }else if (ruleKey.equals("color")) {
                if (color.equals(ruleValue)) {
                    matchCount++;
                }
            }else if (ruleKey.equals("name")) {
                if (name.equals(ruleValue)) {
                    matchCount++;
                }
            }
        }
        return matchCount;
    }
}
