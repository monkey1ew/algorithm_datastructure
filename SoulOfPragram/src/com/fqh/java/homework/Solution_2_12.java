package com.fqh.java.homework;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_2_12 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        LinkedList linkedList = new LinkedList(node1);
        linkedList.insert(node2);
        linkedList.insert(node3);
        linkedList.insert(node4);
        linkedList.insert(node5);

        linkedList.printList();
        linkedList.reverse();
        System.out.println("******************************");
        linkedList.printList();
    }
}

class LinkedList {
    private Node node;
    private Node head;

    public LinkedList(Node node) {
        head = new Node(0);
        this.head.next = node;
    }

    public void reverse() {
        if (head.next == null) {
            return;
        }
        if (head.next.next == null) {
            return;
        }
        Node next = null;
        Node cur = head.next;
        Node newHead = new Node(-1);
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        head.next = newHead.next;
    }

    public void printList() {
        if (head.next == null) {
            System.out.println("链表为空....");
            return;
        }
        Node cur = head.next;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public void insert(Node node) {
        if (head.next == null) {
            head.next = node;
            return;
        }
        Node cur = head.next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
