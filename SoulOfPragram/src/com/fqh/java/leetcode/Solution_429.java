package com.fqh.java.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 429. N 叉树的层序遍历
 */
public class Solution_429 {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);

        List<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        root.children = list;

        Node node4 = new Node(5);
        Node node5 = new Node(6);
        List<Node> list1 = new ArrayList<>();
        list1.add(node4);
        list1.add(node5);
        node1.children = list1;

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node == null) {
                    break;
                }
                list.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
        }
//        System.out.println(res);

        return res;
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
