package com.fqh.java.structure.tree.theadedbinarytree;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "marry");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //后面递归创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);

        //测试线索化二叉树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();

        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.midOrder();
        threadedBinaryTree.threadedNodes();
        //前序线索化
//        threadedBinaryTree.preThreadedNodes();

        //后序线索化
//        threadedBinaryTree.threadedNodes();

        //测试10号节点
        HeroNode leftNode = node5.getLeft();
        System.out.println("10号节点的前驱节点 :" + leftNode);
        HeroNode rightNode = node5.getRight();
        System.out.println("10号节点的后继节点 :" + rightNode);

        //当线索化二叉树后不能再使用原来的遍历方式
//        System.out.println("使用线索化的方式遍历二叉,.,.,.,.,.,");
//        threadedBinaryTree.threadedList(); //8, 3, 10, 1, 14, 6
        threadedBinaryTree.threadedList();

    }
}

//创建线索化二叉树 ThreadedBinaryTree
class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化, 需要创建指向当前节点的前驱节点的指针
    private HeroNode pre = null;
    //在递归进行线索化时, pre总是保留前一个节点

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //重载线索化方法
    public void threadedNodes(){
        this.threadedNodes(root);
    }

    //重载
    public void preThreadedNodes(){
        this.preThreadNodes(root);
    }

    //重载
    public void postThreadedNodes(){
        this.postThreadNodes(root);
    }

    //遍历中序线索化二叉树
    public void threadedList(){
        //定义一个变量,存储当前遍历的节点,从root开始
        HeroNode node = root;
        while (node != null){
            //循环的找到liefType = 1 这个节点 [8 这个节点]
            //node会移动, 当leftType==1时, 说明该节点是按线索化处理的节点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针，指向的是后继节点就一直输出
            while (node.getRightType() == 1){
                //获取到当前节点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            node = node.getRight();
        }
    }

    //遍历前序线索化二叉树
    public void preThreadedList(){
        HeroNode node = root;
        while (node != null) {
            System.out.println(node);
            //循环的找到liefType = 1 这个节点 [8 这个节点]
            //node会移动, 当leftType==1时, 说明该节点是按线索化处理的节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
                System.out.println(node);
            }

            while (node.getRightType() == 1){

                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //后序遍历线索化二叉树
//    public void postThreadedList() {
//        HeroNode node = root;
//        while (node != null){
//            //循环的找到liefType = 1 这个节点 [8 这个节点]
//            //node会移动, 当leftType==1时, 说明该节点是按线索化处理的节点
//            while (node.getLeftType() == 0){
//                node = node.getLeft();
//            }
//            System.out.println(node);
//            //如果当前节点的右指针，指向的是后继节点就一直输出
//            while (node.getRightType() == 1){
//                //获取到当前节点的后继结点
//                node = node.getRight();
//                System.out.println(node);
//            }
//            //替换遍历的节点
//            //打印当前节点
//            node = node.getRight();
//        }
//    }

    //对二叉树中序线索化
    /**
     * @param node 对当前节点线索化
     */
    public void threadedNodes(HeroNode node){
        //node==null, 不能线索化
        if (node == null){
            return;
        }
        //(1)先线索化左子树
        threadedNodes(node.getLeft());
        //(2)线索化当前节点
        //处理当前节点的前驱节点
        //以8号节点为例
        //8节点的left = null
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型, 前驱节点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null){
            //让前驱节点的右指针指向当前node节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        //(3)线索化右子树
        threadedNodes(node.getRight());
    }

    //前序线索化
    public void preThreadNodes(HeroNode node) {
        if (node == null) { //不能线索化
            return;
        }
        //(1)线索化当前节点
        //处理当前节点的前驱节点
        //以8号节点为例
        //8节点的left = null
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型, 前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null){
            //让前驱节点的右指针指向当前node节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        //(2)线索化左子树
        if (node.getLeftType() != 1) { //判断是不是前驱
            preThreadNodes(node.getLeft());
        }
        //(3)线索化右子树
        if (node.getRightType() != 1) { //判断是不是后继
            preThreadNodes(node.getRight());
        }
    }
    //后序线索化
    public void postThreadNodes(HeroNode node){
        if (node == null){
            return;
        }
        if(node.getLeftType() != 1){
            postThreadNodes(node.getLeft());
        }
        if (node.getRightType() != 1){
            postThreadNodes(node.getRight());
        }

        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }



    //删除节点
    public void delNode(int no){
        if (root != null){
            //如果root就是一个节点,判断root是不是要删除的
            if (root.getNo() == no){
                root = null;
            }else {
                //递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("空的树,.,.,.,.,.,.");
        }
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空, 无法遍历");
        }
    }

    //中序
    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空, 无法遍历");
        }
    }

    //后序
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空, 无法遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public HeroNode midOrderSearch(int no){
        if (root != null){
            return root.midOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}


//创建HeroNode
@Data
@SuppressWarnings("all")
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认null
    private HeroNode right;

    //1.如果leftType == 0:表示指向左子树, ==1表示指向前驱节点
    //2.如果rightType == 0:表示指向右子树, ==1表示指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no) {
        //当前节点的左子节点不为空，并且no == no
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //当前节点的右子节点不为空，并且no == no
        if (this.right != null && this.right.no == no){
            HeroNode temp = null;
            if (this.right.left != null){
                temp = this.right.left;
            }
            this.right = null;
            this.right = temp;
            return;
        }
        //4.向左子树进行递归删除
        if (this.left != null){
            this.left.delNode(no);
        }
        //5.向右子树进行递归删除
        if (this.right != null){
            this.right.delNode(no);
        }
    }


    //前序遍历
    public void preOrder(){
        System.out.println(this); //先输入父节点
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void midOrder(){
        //递归向左字数中序遍历
        if (this.left != null){
            this.left.midOrder();
        }
        //输出父节点
        System.out.println(this);
        //向右子树中序遍历
        if (this.right != null){
            this.right.midOrder();
        }
    }
    //后续遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    //前序遍历查找
    /**
     * @param no 查找的no
     * @return 找到返回该node
     */
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历----");
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        //判断当前节点的左子节点是否为Null, 不为空, 则递归查找
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){ //说明左子树上找到
            return resNode;
        }
        //左边子节点没找到， 就找右子节点
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找  左 - 中 - 右
    public HeroNode midOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.midOrderSearch(no);
        }
        if (resNode != null){ //说明左子树上找到
            return resNode;
        }
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        //找右子节点
        if (this.right != null){
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找 左-右-中
    public HeroNode postOrderSearch(int no) {
        //判断左是否为Null
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        //判断右子节点
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //左右子树都没找到, 比较当前节点
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}