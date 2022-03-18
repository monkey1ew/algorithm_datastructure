package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1361. 验证二叉树
 */
public class Solution_1361 {

    public static void main(String[] args) {
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, 3, -1, -1};

        System.out.println(validateBinaryTreeNodes(4, leftChild, rightChild));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Union_Find uf = new Union_Find(n);

        for (int i = 0; i < n; i++) {
            int p = leftChild[i];
            int q = rightChild[i];
            if (p != -1 && q != -1) {
                if (uf.isConnected(i, p)) { //i和i的孩子已经在同一连通分量中
                    return false;
                }
                uf.union(i, p);
                if (uf.isConnected(i, q)) {
                    return false;
                }
                uf.union(i, q);
            }
        }
        return uf.getCount() == 1; //最后只剩一个集合则是二叉树
    }
}


class Union_Find {
    private int[] parent;
    private int count;
    public Union_Find(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
        count--;
    }

    public boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        return pRoot == qRoot;
    }

    public int getCount() {
        return count;
    }
}