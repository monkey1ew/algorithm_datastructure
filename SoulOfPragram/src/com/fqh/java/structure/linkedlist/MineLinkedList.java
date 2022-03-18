package com.fqh.java.structure.linkedlist;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
@SuppressWarnings("all")
public class MineLinkedList {

    public static void main(String[] args) {

        Node node1 = new Node(1, "jack");
        Node node2 = new Node(2, "tom");
        Node node3 = new Node(3, "smith");
        Node node4 = new Node(4, "milan");

        LinkedList_ linkedList = new LinkedList_();
        linkedList.addByNo(node2);
        linkedList.addByNo(node1);
        linkedList.addByNo(node4);
        linkedList.addByNo(node3);

//        System.out.println("删除前.......");
        linkedList.list();
//
//        linkedList.delete(1);
//        linkedList.delete(4);
//        linkedList.delete(2);
        linkedList.delete(3);
//        System.out.println("删除后.......");
//        linkedList.list();

        System.out.println("链表中有效节点数=" + linkedList.size());
        System.out.println("链表倒数第1个节点=" + linkedList.get(1));


//        System.out.println("删除链表倒数4个节点, 返回有效节点的头节点=" + linkedList.deleteByK(4));
//        System.out.println("删除链表倒数3个节点, 返回有效节点的头节点=" + linkedList.deleteByK(3));
//        System.out.println("删除链表倒数2个节点, 返回有效节点的头节点=" + linkedList.deleteByK(2));
//        System.out.println("删除链表倒数1个节点, 返回有效节点的头节点=" + linkedList.deleteByK(1));
//        linkedList.list();
    }

}


@SuppressWarnings("all")
class LinkedList_{

    private Node head = new Node(0, ""); //头节点

    public void addByNo(Node node){

        //定义辅助指针
        Node temp = head;

        boolean flag = false;

        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > node.no){
                break;
            }else if (temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag){
            node.next = temp.next;
            temp.next = node;
        }else {
            System.out.println("添加的编号存在..........");
        }
    }

    //list
    public void list(){
        if (head.next == null){
            System.out.println("链表为空........");
            return;
        }
        Node temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //delete
    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空.....");
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("编号Node不存在--------");
        }
    }

    //有效节点数
    public int size(){
        if (head.next == null){
            System.out.println("链表为空.......");
            return -1;
        }
        int num = 0;
        Node temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            ++num;
            temp = temp.next;
        }
        return num;
    }

    //求链表倒数第k个节点
    public Node get(int k){
        if (head.next == null) {
            System.out.println("链表为空.......");
            return null;
        }

        boolean flag = false;

        Node temp = head.next;
        for (int i = 1; i <= size(); i++) {
            if ((size() - i) + 1 == k) {
                //说明找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            return temp;
        }else {
            return null;
        }
    }

    //删除链表倒数第k个节点,并返回头节点[第一个有效节点]
    public Node deleteByK(int k){

        if (head.next == null) {
            System.out.println("链表为空.....");
            return null;
        }
        Node temp = head;
        boolean flag = false;
        for (int i = 0; i < size() ; i++) {
            if (temp.next == null){
                break;
            }
            if ((size() - i) == k){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            return head.next;
        }
        return null;
    }
}

class Node{

    public int no;
    public String name;
    public Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' + '}';
    }
}
