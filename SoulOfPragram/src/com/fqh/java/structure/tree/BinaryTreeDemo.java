package com.fqh.java.structure.tree;

import lombok.Data;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //手动创建二叉树, 【后面再递归创建】
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
//        //测试
//        System.out.println("前序遍历"); //1, 2, 3, 5, 4
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");  //2, 1, 5, 3, 4
//        binaryTree.midOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();        //2, 5, 4, 3, 1
//
//        //前序查找
//        System.out.println("前序查找....");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到, 信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//        }else {
//            System.out.printf("没有找到no=%d..",5 );
//        }

        System.out.println("删除前前序遍历,.,.,.,");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后前序遍历,.,.,.,.,.");
        binaryTree.preOrder();
    }
}
//定义二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
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

//创建HeroNode节点
@Data
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认null
    private HeroNode right;

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