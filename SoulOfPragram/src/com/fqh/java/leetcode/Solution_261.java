package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 261. 以图判树
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 */
public class Solution_261 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {2, 3}};
        System.out.println(validTree(4, edges));
    }


    public static boolean validTree(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return false;
        }
        UFD uf = new UFD(n);
        for (int[] link : edges) {
            int p = link[0];
            int q = link[1];
            if (uf.isConnected(p, q)) {
                return false;
            }
            uf.union(p, q);
        }
        return uf.getCount() > 0;
    }
}

class UFD {
    private int[] parent;
    private int count;
    public UFD(int n) {
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

    public boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
        count--;
    }

    public int getCount() {
        return count;
    }
}