package com.fqh.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * LCP 44. 开幕式焰火
 * 输入：root = [1,3,2,1,null,2]
 * 输出：3
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 */
public class LCP_44 {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
    }

    public static int numColor(TreeNode root) {
        if (root == null) {
            return 0;
        }
        set.add(root.val);
        numColor(root.left);
        numColor(root.right);

        return set.size();
    }
}
