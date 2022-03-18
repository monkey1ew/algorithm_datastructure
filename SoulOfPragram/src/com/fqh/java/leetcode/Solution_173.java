package com.fqh.java.leetcode;

import java.util.Stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 173. 二叉搜索树迭代器
 */
public class Solution_173 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        BSTIterator bstIterator = new BSTIterator(root);
        int i = bstIterator.next();
        System.out.println(i);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());

    }
}

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addNode(root);
    }

    public int next() {
        if (stack.size() > 0) {
            return stack.pop().val;
        }
        return -1;
    }

    public boolean hasNext() {
        if (stack.size() > 0) {
            return true;
        }
        return false;
    }

    public void addNode(TreeNode root) {
        if (root == null) {
            return;
        }
        addNode(root.right);
        stack.push(root);
        addNode(root.left);
    }
}
