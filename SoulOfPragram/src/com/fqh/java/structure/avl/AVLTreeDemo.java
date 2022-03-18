package com.fqh.java.structure.avl;

import jdk.nashorn.internal.runtime.JSONListAdapter;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //中序遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("平衡处理后======");
        System.out.println("树的高度 = " + avlTree.getRoot().height());
        System.out.println("树的左子树的高度 = " + avlTree.getRoot().left.height());
        System.out.println("树的右子树的高度 = " + avlTree.getRoot().right.height());
        System.out.println("当前根节点= " + avlTree.getRoot());
    }
}

//创建AVLTree
class AVLTree {
    private Node root;
    public Node getRoot() {
        return root;
    }
    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * @param node 传入的节点-当作二叉排序树的根节点
     * @return 返回的是以node为根节点的BST的最小节点值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点, 就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时target指向了最小节点
        //删除最小节点
        deleteNode(target.value);
        return target.value;
    }

    //删除节点
    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.先找到要删除的节点 targetNode
            Node targetNode = search(value);
            if (targetNode == null) { //没有找到
                return;
            }
            //如果发现当前这颗BST只有一个节点(根节点)
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父节点
            Node parent = searchParent(value);
            //如果删除的节点是  叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                //判断 targetNode是父节点的 左子节点 还是 右子节点
                if (parent.left != null && parent.left.value == value) {
                    //说明 targetNode是父节点的    左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    //说明 targetNode是父节点的    右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //删除有两颗节点的子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                //删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    //targetNode 是 parent 的左子节点
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            //targetNode 是 parent 的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        //如果要删除的节点有右子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else { //targetNode 是 parent 的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
    //添加节点
    public void add(Node node) {
        if (root == null) {
            root = node; //如果root为null直接让root指向node
        } else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }else {
            System.out.println("BST为null");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }


    //返回以   当前节点    为根节点    的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转的方法
    private void leftRotate() {
        //(1)创建新的节点, 用当前根节点的值
        Node newNode = new Node(value);
        //(2)把新的节点的左子树,设置为当前节点的左子树
        newNode.left = left;
        //(3)把新的节点的右子树 设置 为当前节点的右子树的 左子树
        newNode.right = right.left;
        //(4)把当前节点的值 替换 成右子节点的值
        value = right.value;
        //(5)把当前节点的右子树设置成 当前节点的右子树的   右子树
        right = right.right;
        //(6)把当前节点的左子节点 设置成新的节点
        left = newNode;
    }

    //右旋转的方法
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    //查找要删除的节点
    /**
     * @param value 你希望删除的节点的值
     * @return 找到就返回节点, 否则返回null
     */
    public Node search(int value) {
        if (value == this.value) { //找到就是该节点
            return this;
        } else if (value < this.value) { //查找的值 < 当前节点的值, 递归向左找
            //如果左子节点为null
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else { //查找的值 > 当前节点的值, 递归右左找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除节点的父节点

    /**
     * @param value 要找的这个节点的值
     * @return 返回要删除节点的父节点
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                this.right != null && this.right.value == value) {
            return this; //如果当前节点左(右)子节点不为null并且当前节点的左(右)子节点的值等于value--->找到
        } else {
            //如果查找的这个值小于当前节点的值,并且当前节点的左子节点不为null
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) { //向右子树递归查找
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //添加节点的方法
    //递归的形式添加, 需要满足二叉排序树的形式
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值, 和当前子树的根节点的值比较
        if (node.value < this.value) {
            //如果当前节点的左子节点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else { //添加的节点的值大于当前节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }

        //当添加完一个节点后, 如果右子树的高度 - 左子树的高度 > 1
        //进行 左旋
        if (rightHeight() - leftHeight() > 1) {
            //如果当前节点的右子树的 左子树的高度 > 右子树的高度

            if (right != null && right.leftHeight() > right.rightHeight()) {
                //针对右子节点进行右旋转
                right.rightRotate();
                //在针对当前节点进行左旋
                leftRotate(); //左旋
            }else {
                leftRotate();
            }
            return;
        }

        //当添加完一个节点后，如果 左子树高度 - 右子树高度 > 1
        //右旋
        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前节点的 左节点进行(左子树) -> 左旋转
                left.leftRotate();
                //再针对当前进行右旋转
                rightRotate();
            }else {
                //直接进行右旋转即可
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
