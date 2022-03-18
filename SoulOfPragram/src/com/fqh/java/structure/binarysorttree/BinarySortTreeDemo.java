package com.fqh.java.structure.binarysorttree;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环得到添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历
        System.out.println("中序遍历BST");
        binarySortTree.infixOrder();

        //测试删除叶子节点
//        binarySortTree.deleteNode(2);
//        binarySortTree.deleteNode(5);
//        binarySortTree.deleteNode(9);
//        binarySortTree.deleteNode(12);
        System.out.println("删除节点后=================");
//        binarySortTree.infixOrder();

        //测试-删除有2个节点的
        binarySortTree.deleteNode(10);
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree {
    private Node root;
    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }else {
            return root.searchParent(value);
        }
    }

//    public int delLeftTreeMax(Node node) {
//
//    }


    /**
     * @param node 传入的节点-当作二叉排序树的根节点
     * @return  返回的是以node为根节点的BST的最小节点值
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
        }else {
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
                }else if (parent.right != null && parent.right.value == value) {
                    //说明 targetNode是父节点的    右子节点
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null) {
                //删除有两颗节点的子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
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
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if (parent != null) {
                        //如果要删除的节点有右子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else { //targetNode 是 parent 的右子节点
                            parent.right = targetNode.right;
                        }
                    }else {
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


//节点
class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }

    //查找要删除的节点
    /**
     * @param value 你希望删除的节点的值
     * @return 找到就返回节点, 否则返回null
     */
    public Node search(int value) {
        if (value == this.value) { //找到就是该节点
            return this;
        }else if (value < this.value) { //查找的值 < 当前节点的值, 递归向左找
            //如果左子节点为null
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        }else { //查找的值 > 当前节点的值, 递归右左找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除节点的父节点
    /**
     * @param value 要找的这个节点的值
     * @return  返回要删除节点的父节点
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                this.right != null && this.right.value == value) {
            return this; //如果当前节点左(右)子节点不为null并且当前节点的左(右)子节点的值等于value--->找到
        }else {
            //如果查找的这个值小于当前节点的值,并且当前节点的左子节点不为null
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            }else if (value >= this.value && this.right != null) { //向右子树递归查找
                return this.right.searchParent(value);
            }else {
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
            }else {
                //递归的向左子树添加
                this.left.add(node);
            }
        }else { //添加的节点的值大于当前节点的值
            if (this.right == null) {
                this.right = node;
            }else {
                //递归的向右子树添加
                this.right.add(node);
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