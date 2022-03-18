package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 面试题 04.03. 特定深度节点链表
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class Solution_03 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right= node4;
        node2.right = node5;
        node3.left = node6;

        ListNode[] listNodes = listOfDepth(root);
        for (ListNode node : listNodes) {
            System.out.println(node);
        }
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> list = new ArrayList<>();
        ListNode dummyHead = new ListNode(-1);
        while (!queue.isEmpty()) {
            ListNode cur = dummyHead;
            int n = queue.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                cur.next = new ListNode(node.val);
                cur = cur.next;
                arr[i] = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(dummyHead.next);
        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
