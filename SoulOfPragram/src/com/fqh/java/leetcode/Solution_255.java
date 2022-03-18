package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 * 225. 用队列实现栈
 */
public class Solution_255 {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
//
//        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}



class MyStack {
    private Queue<Integer> queue;
    int top_elem = 0;
    public MyStack() {
        queue = new LinkedList<>();

    }

    public void push(int x) {
        queue.offer(x);
        top_elem = x;
    }

    public int pop() {
        if (!queue.isEmpty()) {
            int n = queue.size();
            while (n > 2) {
                queue.offer(queue.poll());
                n--;
            }
            top_elem = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }else {
            throw new RuntimeException("queue is empty");
        }
    }

    public int top() {
        return top_elem;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */