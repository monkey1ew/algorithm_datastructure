package com.fqh.java.structure.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }

    //创建赫夫曼树
    /**
     * @param arr 需要创建哈夫曼树的数组·
     * @return  返回的是哈夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr){
        //1.遍历数组
        //2.将arr的每个元素构建成Node
        //3.将Node放入到ArrayList
        List<Node> nodes = new ArrayList<>();
        for (int value : arr){
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //循环处理过程

            //排序 小----->大
            Collections.sort(nodes);
            System.out.println("nodes = " + nodes);

            //取出根节点权值最小的两颗二叉树
            //(1)取出权值最小的节点 (二叉树)
            Node leftNode = nodes.get(0);
            //(2)取出第二小的节点
            Node rightNode = nodes.get(1);

            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4)从ArrayList中删除处理过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent 加入nodes
            nodes.add(parent);

        }

        //返回最后这个节点, 哈夫曼树的root节点
        return nodes.get(0);
    }

    public static void preOrder(Node root){
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空树无法便利....");
        }
    }
}

//创建节点类
//让Node对象排序, 实现comparable接口
class Node implements Comparable<Node>{
    int value; //节点权值
    char c; //字符
    Node left; //指向左子节点
    Node right; //指向右子节点

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大进行排序
        return this.value - o.value;
    }
}
