package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 118. 多余的边
 */
public class Solution_118 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }


    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] link : edges) {
            int p = link[0];
            int q = link[1];

            if (uf.connected(p, q)) {
                return new int[] {p, q};
            }
            uf.union(p, q);
        }
        return new int[0];
    }
}



class  UnionFind{
    private int[] parent; //节点x的父节点是parent[x]
    private int count;
    public UnionFind(int n) {
        this.count = n;
        //父节点初始指向自己
        this.parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    //返回父节点
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }
    //判断是否形成回路
    public boolean connected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    //合并
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}