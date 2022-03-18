package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 559. N 叉树的最大深度
 */
public class Solution_559 {

    public static void main(String[] args) {

    }

    public static int maxDepth(Node root) {
        return bfs(root);
    }

    public static int bfs(Node root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node == null) {
                    break;
                }
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            ++depth;
        }
        System.out.println(depth);
        return depth;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
