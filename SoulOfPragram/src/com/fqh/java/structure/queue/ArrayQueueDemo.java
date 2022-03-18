package com.fqh.java.structure.queue;

import java.util.Scanner;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        //测试
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.listQueue();
                    break;
                case 'a':
                    System.out.println("请输入你要添加的数 :");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头数据
                    try {
                        int result = arrayQueue.headQueue();
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



//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize; //表示数组的最大容量
    private int front;   //队列头
    private int rear;    //队列尾
    private int[] arr;   //该数组用于存放数据

    //创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部的前一个位置
        rear = -1;  //指向队列尾部
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满, 不能加入数据...");
            return;
        }
        rear++; //让rear后移
        arr[rear] = n;
        //上面两段代码等价 arr[++rear] = n
    }

    //获取队列数据, 出队列[先进先出]
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("队列空, 不能取数据");
        }
        front++; //让front后移
        return arr[front];
        //上面两段代码等价 arr[++front]
    }

    //显示队列的所有数据
    public void listQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列为空......");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据[不是取出数据]
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列为空......");
        }

        return arr[front + 1];
    }

}