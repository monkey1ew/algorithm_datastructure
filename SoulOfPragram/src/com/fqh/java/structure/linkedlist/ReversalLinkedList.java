package com.fqh.java.structure.linkedlist;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class ReversalLinkedList {

    public static void main(String[] args) {

        StudentNode node1 = new StudentNode(1, "jack");
        StudentNode node2 = new StudentNode(2, "tom");
        StudentNode node3 = new StudentNode(3, "smith");
        StudentNode node4 = new StudentNode(4, "marry");

        ReLinkedList reLinkedList = new ReLinkedList();
        reLinkedList.addByNo(node2);
        reLinkedList.addByNo(node1);
        reLinkedList.addByNo(node4);
        reLinkedList.addByNo(node3);

        reLinkedList.list();


        StudentNode studentNode = reLinkedList.reversal(reLinkedList.getHead());



    }
}


@SuppressWarnings("all")
class ReLinkedList {

    private StudentNode head = new StudentNode(0, "");

    public StudentNode getHead() {
        return head;
    }

    public void addByNo(StudentNode node) {

        //定义辅助指针
        StudentNode temp = head;

        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.println("添加的编号存在..........");
        }
    }

    //list
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空........");
            return;
        }
        StudentNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //reversal 反转
    public StudentNode reversal(StudentNode head){
        StudentNode reversalHead = new StudentNode(0, "");

        if (head.next == null){
            System.out.println("链表为空.......");
            return null;
        }


        StudentNode temp1 = head;

        StudentNode temp2 = reversalHead.next;
        while (true){
            if (temp1 == null){
                break;
            }

            //将第一个元素插入到 reversalHead头节点的后面
            if (temp2 == null) {
                temp2 = temp1.next;
            }else {

            }

            //指针后移
            temp1 = temp1.next;
        }

        return reversalHead;

    }
}

class StudentNode{

    public int no;
    public String name;
    public StudentNode next;

    public StudentNode(int no, String name) {
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
