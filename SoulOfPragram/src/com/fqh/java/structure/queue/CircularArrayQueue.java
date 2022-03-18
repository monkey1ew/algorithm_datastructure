package com.fqh.java.structure.queue;

import java.util.Scanner;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 循环队列[拿出数组的一个空间,实现循环队列,rear和front都在不停的移动]
 */
@SuppressWarnings("all")
public class CircularArrayQueue {
    public static void main(String[] args) {

        //队列的有效数据最大为3[拿出一个空间出来]
        CircularQueue circularQueue = new CircularQueue(4);

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
                    circularQueue.list();
                    break;
                case 'a':
                    System.out.println("请输入你要添加的数 :");
                    int value = scanner.nextInt();
                    circularQueue.add(value);
                    break;
                case 'g': //取出数据
                    try {
                        int result = circularQueue.get();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头数据
                    try {
                        int result = circularQueue.showHead();
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


class CircularQueue{
    private int maxSize; //表示数组的最大容量
    private int front;   //队列头
    private int rear;    //队列尾
    private int[] arr;   //该数组用于存放数据

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //判断环形队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //判断环形队列是否满了
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //环形列队的有效个数
    public int effectNums(){
        return (rear + maxSize- front) % maxSize;
    }

    //添加
    public void add(int n){
        if (isFull()){
            System.out.println("队列满, 不能加入数据...");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //将rear后移
    }

    //取出
    public int get(){
        if (isEmpty()) {
            throw new RuntimeException("队列空了......");
        }
       int temp = arr[front];
       front = (front + 1) % maxSize; //将front后移

       return temp;
    }

    //显示所有元素
    public void list(){
        if (isEmpty()){
            System.out.println("队列为空......");
            return;
        }
        //从front开始遍历, 遍历多少个元素
        for (int i = front; i < front + effectNums(); i++) {
            //i有可能超过arr的大小[环形]取模
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示头数据
    public int showHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空.......");
        }

        return arr[front];
    }

}
