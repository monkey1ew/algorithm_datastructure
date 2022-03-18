package com.fqh.java.structure.queue;

import java.util.Scanner;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class MineQueue {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(4);

        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag){
            System.out.println("s(list): 显示队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("e(exit): 退出程序");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    myQueue.list();
                    break;
                case 'a':
                    System.out.println("请输入你要添加的数 :");
                    int value = scanner.nextInt();
                    myQueue.add(value);
                    break;
                case 'g': //取出数据
                    try {
                        int result = myQueue.get();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头数据
                    try {
                        int result = myQueue.head();
                        System.out.printf("队列头数据为%d\n", result);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    System.out.println("程序退出...............");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class MyQueue{
    //拿出一个空间 maxSize为4 最多只能存3个元素
    private int maxSize;
    private int front;  //指向队列头部
    private int rear;   //指向队列最后一个元素的后一个位置
    private int[] arr;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //队列的有效元素个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //添加操作
    public void add(int n){
        if (isFull()){
            System.out.println("队列满了.........");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //将rear后移

    }

    //取出操作
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列为空.......");
        }

        int temp = arr[front]; //将front的值保存到temp
        front = (front + 1) % maxSize; //将front后移
        return temp;
    }

    //列出所有元素
    public void list(){
        if (isEmpty()){
            System.out.println("队列为空.........");
            return;
        }

        //从front开始 -----> front + 有效个数 [i 可能比数组大]
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //查看头元素
    public int head(){
        if (isEmpty()){
            throw new RuntimeException("队列为空......");
        }

        return arr[front];
    }
}
