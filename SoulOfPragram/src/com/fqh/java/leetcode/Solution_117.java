package com.fqh.java.leetcode;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Solution_117 {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = null;

        Node node6 = new Node(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        node2.right = node6;

        Node newRoot = connect(root);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node newHead = new Node(0);
            Node p = newHead;
            while (cur != null) {
                if (cur.left != null) {
                    p.next = cur.left;
                    p = p.next;
                }
                if (cur.right != null) {
                    p.next = cur.right;
                    p = p.next;
                }
                cur = cur.next;
            }
            cur = newHead.next;
        }

        return root;
    }

//    public static void connectTwoNode(Node node1, Node node2) {
//        if (node1 == null || node2 == null) {
//            return;
//        }
//        node1.next = node2;
//
//        connectTwoNode(node1.left, node1.right);
//        connectTwoNode(node2.left, node2.right);
//
//        if (node1.right == null) {
//            if (node2.left != null) {
//                connectTwoNode(node1.left, node2.left);
//            }else {
//                connectTwoNode(node1.left, node2.right);
//            }
//        }else {
//            if (node2.left != null) {
//                connectTwoNode(node1.right, node2.left);
//            }else {
//                connectTwoNode(node1.right, node2.right);
//            }
//        }
//    }
}
