package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 547. 省份数量
 */
public class Solution_116_ {

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }


    public static int findCircleNum(int[][] isConnected) {
        Uf1 uf = new Uf1(isConnected.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) { //如果为1就联通
                    uf.union(i , j);
                }
            }
        }
        return uf.getCount();
    }
}

class Uf1 {
    private int count;
    private int[] parent;

    public Uf1(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
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
    public boolean connected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }
    public int getCount() {
        return count;
    }
}
