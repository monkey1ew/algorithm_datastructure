package com.fqh.java.structure.stack;

import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 逆波兰计算器
 */
public class PolandNotation {

    public static void main(String[] args) {
        
        //完成中缀表达式-------->后缀表达式
        //1.将字符串转成一个中缀表达式对应的List集合
        //2. "1+((2+3)*4)-5 ==> Arraylist [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的list--------->后缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式----------->" + list);
        List<String> parseSuffixExpression = parseSuffixExpression(list);
        System.out.println("后缀表达式----->" + parseSuffixExpression);


        System.out.printf("expression=%d", calculate(parseSuffixExpression));

    }

    //方法 :将得到的中缀表达式对应的list--------->后缀表达式
    public static List<String> parseSuffixExpression(List<String> ls){
        //定义  符号栈 数字栈
        Stack<String> s1 = new Stack<>(); //符号
        //s2 栈在整个转换的过程中没有Pop的操作, 不用stack
        List<String> s2 = new ArrayList<>(); //保存中间结果

        //遍历
        for (String item : ls){
            //如果是数字, 就加入到s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号, 依次pop出符号栈的元素加入到s2 直到遇到左括号
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); //将 ( 弹出 ,括号相消
            }else {
                //当item的优先级 <= s1栈顶运算符的优先级, 弹出s1栈顶的优先级加入到s2
                //缺少比较优先级的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //最后将item压入栈中
                s1.push(item);
            }
        }

        //将s1剩余的加入到s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;  //因为存放到List 按顺序输出就是对应的表达式
    }


    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        //存放对应的内容
        List<String> list = new ArrayList<>();
        int i = 0; //指针, 遍历中缀表达式
        String str; //拼接多位数
        char c; //每遍历一个字符,就放入到c
        do {
            //如果c是一个非数字, 就加入到list
            //   ASCLL < 48   ASCLL > 57 就不是数字   [48, 57]才是数字
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57) {
                list.add("" + c);
                i++; //指针后移
            }else { //如果是一个数,需要考虑多位数
                str = ""; //将str 置空
                while (i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57){
                    str += c; //拼接
                    i++;
                }
                list.add(str);
            }

        }while (i < s.length());

        return list;
    }



    //完成对逆..表达式的运算
    /**
     * 从左至右, 将3 和4压入栈中
     * 遇到 + 运算, 弹出4 和 3(4 为栈顶， 3为栈底)，计算3 + 4的值，再将7入栈
     * 将5 入栈
     * 下面 * 运算，弹出5和7，计算 5 * 7 =35， 将35入栈
     * 将6入栈
     * 最后 - 运算， 计算35-6的值 ，为29
     */

    public static int calculate(List<String> list){
        //创建一个栈, 只需要一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list) {
            //使用正则表达式
            if (item.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(item);
            }else {
                //pop出两个数 并运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算错误....");
                }
                //把res 入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据就是结果
        return Integer.parseInt(stack.pop());
    }



}

//编写一个类Operation 返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回对应优先级的数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在运算符-----------");
                break;
        }
        return result;
    }
}
