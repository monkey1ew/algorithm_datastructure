package com.fqh.java.structure.stack;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class Calculator {
    public static void main(String[] args) {
        //表达式的运算
        String  expression = "7*5-9+4";
        //创建两个栈 数栈-------符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关变量
        int index = 0; //用于表达式的扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描的char保存到ch
        String keepNum = ""; //用于拼接多位数
        //循环扫描expression
        while (true){
            //依次得到expression 的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch 是什么
            if (operStack.isOper(ch)){ //如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()){
                    //如果有操作符, 如果当前符号的优先级<=符号栈的优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        //从数栈pop出两个数进行运算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //把当前的符号入符号栈
                        operStack.push(ch);
                    }else {
                        //如果当前符号的优先级 > 符号栈的操作符, 就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入符号栈..
                    operStack.push(ch);
                }

            }else { //如果时是数字 直接入数栈
//                String s = String.valueOf(ch);
//                Integer num = Integer.valueOf(s);
//                numStack.push(num);
                //1.当处理多位数时, 不能发现一个数就立即入栈, 因为可能是多为数
                //2.在入数栈时, 需要向expression 的index继续扫描,如果后面是符号才入栈
                //3.需要定义一个变量 字符串用于拼接
                keepNum += ch;

                //如果ch已经是expression的最后一位,直接入数栈
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }
                else {
                    //判断下一个字符是不是数字, 如是数字继续扫描;下一个为运算符则才能入数栈
                    //index本身不++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符, 则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //!!!!!!!!!!清空keepNum
                        keepNum = "";
                    }
                }
            }
            //让index + 1, 是否扫描到expression的最后
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        //当表达式扫描完毕,就顺序的从数栈和符号栈pop出相应的数和符号, 并运算
        while (true){
            //如果符号栈为空, 则计算到最后的结果, 数栈只有最后一个数字[结果]
            if (operStack.isEmpty()){
                break;
            }
            //从数栈pop出两个数进行运算
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //把运算的结果入数栈
            numStack.push(res);
        }
        //将结果pop
        System.out.printf("表达式 %s = %d", expression, numStack.pop());
    }
}

//先创建一个栈
//需要扩展功能
class ArrayStack2{
    private int maxSize;    //栈的大小
    private int[] stack;    //数组模拟栈
    private int top = -1;   //表示栈顶, 初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //增加一个方法，可以返回当前栈顶的值, 不是pop
    public int peek(){
        return stack[top];
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

    //返回运算符的优先级, 优先级使用数字表示[数字越大优先级越高]
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1; //有问题 + - * /
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper){
        int res = 0; //用于存放计算得到结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
