package com.fqh.java.structure.stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class LinkedListStack {
    public static void main(String[] args) {

        ListStack listStack = new ListStack();
        listStack.push(new Node(1));
        listStack.push(new Node(2));
        listStack.push(new Node(3));
        listStack.push(new Node(4));
        Node node = listStack.pop();
        Node node1 = listStack.pop();
        Node node2 = listStack.pop();
        Node node3 = listStack.pop();
        System.out.println(node);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
    }

}




class ListStack{
    private Node head = new Node(-1);

    public void push(Node node){
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public Node pop(){
        if (head.next == null){
            throw new RuntimeException("栈为空.....");
        }
        Node temp = head;

        while(true){
            if(temp.next.next == null){
                break;
            }
            temp = temp.next;
        }
        Node node = temp.next;
        temp.next = null;
        return node;

    }


}

class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}