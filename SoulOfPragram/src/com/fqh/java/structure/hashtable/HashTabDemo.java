package com.fqh.java.structure.hashtable;

import javax.management.timer.TimerNotification;
import java.util.Scanner;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class HashTabDemo {

    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员" );
            System.out.println("exit: 退出");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "del":
                    System.out.println("请输入你要删除的Emp的id");
                    id = scanner.nextInt();
                    hashTab.deleteById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);

            }
        }
    }
}

//hashtable管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示共有多少条链表
    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化 链表数组
        empLinkedListArray = new EmpLinkedList[size];
        //分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id, 得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp加入到对应链表
        empLinkedListArray[empLinkedListNo].addById(emp);

    }

    //遍历所有的链表, 遍历hashtable
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i + 1);
        }
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        //使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d条链表中找到该雇员 id = %d\n", empLinkedListNo + 1, id);
        }else {
            System.out.println("在hash表中没有找到该雇员");
        }
    }

    //根据输入的id删除Emp
    public void deleteById(int id){
        //使用散列函数定位到对应链表
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].delete(empLinkedListNo);
    }

    //散列函数, 简单取模法
    public int hashFun(int id){
        return id % size;
    }
}


//表示雇员
class Emp{
    public int id;
    public String name;
    public Emp next; //默认为null

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}

//雇员链表
class EmpLinkedList{
    //头指针, 指向第一个Emp, head直接指向第一个Emp
    private Emp head; //默认null

    //添加雇员到链表
    //1.假定，添加雇员时，id是自增长的,小--->大
    // 采用尾插法
//    public void add(Emp emp){
//        //如果是添加第一个雇员
//        if (head == null){
//            head = emp;
//            return;
//        }
//        //定义辅助指针，找到链表的最后
//        Emp curEmp = head;
//        while (true){
//            if (curEmp.next == null){ //说明到链表最后
//                break;
//            }
//            curEmp = curEmp.next; //后移
//        }
//        //将emp 加入到最后
//        curEmp.next = emp;
//    }

    //按照id的顺序添加
    public void addById(Emp emp){
        if (head == null){
            //如果是添加第一个雇员
            head = emp;
            return;
        }
        Emp newHead = new Emp(-1, "");
        newHead.next = head;
        Emp curEmp = newHead;
        boolean flag = false; //判断编号是否存在
        while (true){
            if (curEmp.next == null){ //说明到链表最后
                break;
            }
            if (curEmp.next.id > emp.id){//说明找到
                break;
            }
            if (curEmp.next.id == emp.id){
                flag = true;//说明编号已存在
                break;
            }
            curEmp = curEmp.next;
        }
        if (!flag){
            emp.next = curEmp.next;
            curEmp.next = emp;
            head = newHead.next; //把添加后的链表赋给 head
            System.out.println("添加成功........");
        }else {
            System.out.println("添加的编号已存在....");
        }
    }

    //遍历链表的雇员信息
    public void list(int no){
        if (head == null){ //链表为空
            System.out.println("第"+ no +"条链表为空.....");
            return;
        }
        System.out.print("第" + no + "条链表的信息为------");
        Emp curEmp = head; //辅助指针
        while (true){
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null){//说明curEmp是最后一个节点
                break;
            }
            curEmp = curEmp.next; //后移
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        //判断链表是否为空
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){ //找到
                break; //这时curEmp就指向emp
            }
            //退出
            if (curEmp.next == null){ //遍历完链表没有找到
                curEmp = null;
                break;
            }
            curEmp = curEmp.next; //后移
        }
        return curEmp;
    }

    //根据id删除Emp
    public void delete(int id){
        if (head == null){
            System.out.println("链表为空....");
            return;
        }
        Emp newHead = new Emp(-1, ""); //构建newHead指向head
        newHead.next = head;

        Emp curEmp = newHead; //辅助指针
        boolean flag = false;
        while (true){
            if (curEmp.next.id == id){
                //找到
                flag = true;
                break;
            }
            if (curEmp.next.next == null){ //找到链表的最后都没找到
                break;
            }
            curEmp = curEmp.next;
        }
        if (flag){
            curEmp.next = curEmp.next.next;//删除操作
            head = newHead.next; //把被删除节点的链表重新赋给head
            System.out.println("删除成功~~~~~");
        }else {
            System.out.println("没有找到该id对应的Emp");
        }
    }
}