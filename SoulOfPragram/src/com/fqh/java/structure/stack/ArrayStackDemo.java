package com.fqh.java.structure.stack;

import java.util.Scanner;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

        //Test
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean flag = true; //控制是否退出
        Scanner scanner = new Scanner(System.in);

        while (flag){
            System.out.println("list : 显示栈");
            System.out.println("push : 入栈");
            System.out.println("pop : 出栈");
            System.out.println("exit : 退出程序");
            System.out.println("请输入key :");
            key = scanner.next();
            switch (key){
                case "list":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数 :");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("出栈的数据-----> %d\n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
            }
        }
    }
}


//数组模拟栈
class ArrayStack{
    private int maxSize;    //栈的大小
    private int[] stack;    //数组模拟栈
    private int top = -1;   //表示栈顶, 初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //判断栈是否满
        if (isFull()){
            System.out.println("栈满..............");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop, 将栈顶的数据返回
    public int pop(){
        //判断栈是否空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空........");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，从上往下, 先进后出
    public void list(){
        if (isEmpty()){
            System.out.println("栈空...........");
            return;
        }

        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}