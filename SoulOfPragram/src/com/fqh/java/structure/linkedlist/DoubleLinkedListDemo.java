package com.fqh.java.structure.linkedlist;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        System.out.println("测试双向链表-------------------------");
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addById(node2);
        doubleLinkedList.addById(node1);
        doubleLinkedList.addById(node4);
        doubleLinkedList.addById(node3);


        HeroNode2 node5 = new HeroNode2(4, "林冲", "豹子头");

        doubleLinkedList.addById(node5);
        doubleLinkedList.list();
    }
}

//        //修改
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙身", "入云龙");
//        doubleLinkedList.update(newHeroNode);
//
//        System.out.println("修改后的链表------------------------------------");
//        doubleLinkedList.list();
//
//        //删除
//        doubleLinkedList.delete(3);
//        System.out.println("删除后-------------------------");
//        doubleLinkedList.list();


class DoubleLinkedList {
    //初始化头节点[不存放具体数据]
    private HeroNode2 head = new HeroNode2(0, "", "");


    public HeroNode2 getHead() {
        return head;
    }

    //按照编号add
    public void addById(HeroNode2 heroNode) {

        //定义辅助指针来遍历链表
        //temp是位于添加位置的前一个节点
        HeroNode2 temp = head;

        boolean flag = false; //判断添加的编号是否存在

        while (true) {

            if (temp.next == null) { //说明temp已经在链表的最后
                break;
            }

            if (temp.next.no > heroNode.no) { //位置找到
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true; //编号存在
                break;
            }
            //将指针后移
            temp = temp.next;

        }
        //判断flag
        if (!flag) {
            if (temp.next != null) {
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                heroNode.pre = temp;
                temp.next = heroNode;
            } else {
                temp.next = heroNode;
                heroNode.pre = temp;
            }
        } else {
            System.out.println("准备插入的node的编号" + heroNode.no + "已存在......");
        }
    }


    //add(普通添加在双向链表的尾部)
    public void add(HeroNode2 heroNode) {

        //定义一个辅助指针temp遍历链表
        HeroNode2 temp = head;
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
        //pre指向temp
        heroNode.pre = temp; //构成双向链表
    }

    //修改一个节点[和单链表一样, 节点类型不一样]
    public void update(HeroNode2 newHeroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空.......");
            return;
        }
        //定义辅助指针
        HeroNode2 temp = head.next;

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

    //从双向链表删除一个节点
    //1.双向链表可直接找到要删除的在这个节点
    //2.自我删除
    public void delete(int no){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空.........");
            return;
        }
        //定义辅助指针
        HeroNode2 temp = head.next;
        //判断是否找到
        boolean flag = false;

        while (true){
            if (temp == null){ //已经到链表的最后
                break;
            }
            if (temp.no == no){
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //将指针后移
            temp = temp.next;
        }
        //判断flag
        if (flag){
            //让temp的前一个节点的next指向temp的下一个节点[next]
            temp.pre.next = temp.next;
            //让temp的下一个节点的pre指向temp的前一个节点[pre]
            //这里有问题----如果是最后一个节点就不需要执行下面[NullPointException]
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("没有找到要删除的Node");
        }
    }




    //显示链表[通过一个temp赋值指针遍历]
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空........");
            return;
        }
        //定义辅助指针temp
        HeroNode2 temp = head.next;
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

//创建节点类
class HeroNode2{

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;   //指向下一个节点,默认null
    public HeroNode2 pre;    //指向前一个节点,默认null

    public HeroNode2(int no, String name, String nickname) {
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
