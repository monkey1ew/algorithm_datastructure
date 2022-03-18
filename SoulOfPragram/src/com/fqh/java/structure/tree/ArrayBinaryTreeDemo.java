package com.fqh.java.structure.tree;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //创建ArrayBinaryTree
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
//        arrayBinaryTree.preOrder(); //1, 2, 4, 5, 3, 6, 7
//         arrayBinaryTree.midOrder();  // 4, 2, 5, 1, 6, 3, 7
        arrayBinaryTree.postOrder(0); //4, 5, 2, 6, 7, 3, 1
    }
}


//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历

class ArrayBinaryTree {
    private int[] arr; //存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOrder
    public void preOrder(){
        this.preOrder(0);
    }

    public void midOrder(){
        this.midOrder(0);
    }

    //完成顺序存储二叉树的前序遍历
    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空, 或则arr.length = 0;
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //中序
    public void midOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if (index * 2 + 1 < arr.length){
            midOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        if (index * 2 + 2 < arr.length){
            midOrder(index * 2 + 2);
        }
    }

    //后序遍历
    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if (index * 2 + 1 < arr.length){
            postOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length){
            postOrder(index * 2 + 2);
        }
        System.out.print(arr[index] + "\t");
    }
}