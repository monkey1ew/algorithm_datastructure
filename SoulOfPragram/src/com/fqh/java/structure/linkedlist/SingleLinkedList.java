package com.fqh.java.structure.linkedlist;

import java.util.Stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class SingleLinkedList {

    public static void main(String[] args) {

        //测试
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode node5 = new HeroNode(1, "jack", "鸡哥");

        LinkedList linkedList = new LinkedList();
        //add【按照编号的顺序】
        linkedList.addById(node1);
        linkedList.addById(node4);
        linkedList.addById(node2);
        linkedList.addById(node3);

        linkedList.list();
        System.out.println("---------------------------");

        //测试
        HeroNode res = findLastIndexNode(linkedList.getHead(), 1);
        System.out.println("res=" + res);

//        reverseList(linkedList.getHead());
//        linkedList.list();

        System.out.println("逆序打印单链表------------");
        reversPrint(linkedList.getHead());


    }

    //使用stack对链表逆序打印
    public static void reversPrint(HeroNode head){
        if (head.next == null){
            System.out.println("链表空......");
            return;
        }

        //创建一个栈, 将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点, 压入栈中
        while (cur != null){
            stack.push(cur);
            //指针后移
            cur = cur.next;
        }

        //将栈中的节点打印 pop
        while (stack.size() > 0){
            System.out.println(stack.pop()); //出栈
        }
    }

    //将单链表反转
    public static void reverseList(HeroNode head){
        //如果当前链表为Null 或者只有一个节点
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义辅助指针[遍历原来的链表]
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历链表, 取出一个节点，放在新的head的头部
        while (cur != null){
            next = cur.next; //保存当前节点的下一个节点, 后面需要使用
            cur.next = reverseHead.next; //将cur的下一个节点指向新的链表的头部
            reverseHead.next = cur;
            cur = next; //让cur后移
        }
        //将head.next 指向 reverseHead.next ,实现反转
        head.next = reverseHead.next;
    }

    //查找单链表中倒数第k个节点[面试题]
    //1.编写一个方法, 接收head节点, 接收一个index
    //2.index 表示倒数第index个节点
    //3.遍历链表,得到链表的长度
    //4.得到size后, 从链表的第一个开始遍历(size-index)个
    //5. 找到了就返回
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        //判断链表是否空
        if (head.next == null){
            return null; //没有找到
        }
        //第一个遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历 size-index 位置,就是倒数第k个节点
        //数据校验
        if (index <= 0 || index > size){
            return null;
        }
        //定义辅助指针
        HeroNode temp = head.next;
        //for
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;

    }

    /**
     * @param head 链表的头节点
     * @return  返回的就是链表的有效节点的个数
     */
    public static int getLength(HeroNode head){
        if (head.next == null){ //空链表
            return 0;
        }
        int length = 0;
        //定义辅助变量
        HeroNode temp = head.next;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}


//定义SingleLinkedList 管理Node节点
@SuppressWarnings("all")
class LinkedList{

    //初始化头节点[不存放具体数据]
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //delete[删除节点]
    public void delete(int no){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空.........");
            return;
        }
        //定义辅助指针
        HeroNode temp = head;
        //判断是否找到
        boolean flag = false;

        while (true){
            if (temp.next == null){ //已经到链表的最后
                break;
            }
            if (temp.next.no == no){
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //将指针后移
            temp = temp.next;
        }
        //判断flag
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到要删除的Node");
        }
    }

    //update[修改], 根据编号来修改, no不修改
    //1. 根据newHeroNode的no来修改
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空.......");
            return;
        }
        //定义辅助指针
        HeroNode temp = head.next;

        //判断no是否存在
        boolean flag = false;

        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;    //找到
                break;
            }
            //将指针后移
            temp = temp.next;
        }
        //判断flag
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("编号不存在");
        }

    }


    //add[根据编号大小添加]
    public void addById(HeroNode heroNode){

        //定义辅助指针来遍历链表
        //temp是位于添加位置的前一个节点
        HeroNode temp = head;

        boolean flag = false; //判断添加的编号是否存在

        while (true){
            if (temp.next == null){ //说明temp已经在链表的最后
                break;
            }

            if (temp.next.no > heroNode.no){ //位置找到,temp的后面插入
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true; //编号存在
                break;
            }
            //将指针后移
            temp = temp.next;

        }
        //判断flag
        if (!flag) {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }else {
            System.out.println("准备插入的node的编号"+ heroNode.no + "已存在......");
        }
    }


    //添加Node节点
    //不考虑编号的顺序
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

        //定义一个辅助指针temp遍历链表
        HeroNode temp = head;
        //遍历,找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }

            //如果没有找到, 就将temp后移
            temp = temp.next;
        }
        //当退出while循环时, temp就指向了链表的最后
        temp.next = heroNode;
    }

    //显示链表[通过一个temp赋值指针遍历]
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            return;
        }
        //定义辅助指针temp
        HeroNode temp = head.next;
        //遍历,找到最后
        while (true){
            if (temp == null) {
                break;
            }

            //输出节点信息
            System.out.println(temp);

            //将temp指针后移
            temp = temp.next;
        }
    }
}



//定义Node节点
class HeroNode{

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;   //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + "}";
    }
}
