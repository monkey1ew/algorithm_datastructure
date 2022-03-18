package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1379. 找出克隆二叉树中的相同节点
 */
public class Solution_1379 {
    public static void main(String[] args) {

        TreeNode clone = new TreeNode(7);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(19);
        clone.left = node1;
        clone.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode target = new TreeNode(3);
        

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        traverse(original, cloned);
        return res;
    }
    TreeNode target, res;

    void traverse(TreeNode original, TreeNode cloned) {
        if (original == null || res != null) {
            return;
        }
        if (original == target) {
            res = cloned;
            return;
        }
        traverse(original.left, cloned.left);
        traverse(original.right, cloned.right);
    }
}
