package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1319. 连通网络的操作次数
 */
public class Solution_1319 {

    public static void main(String[] args) {
        int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        System.out.println(makeConnected(6, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UF2 uf = new UF2(n);
        for (int[] link : connections) {
            int p = link[0];
            int q = link[1];
            if (uf.isConnected(p, q)) {
                continue;
            }
            uf.union(p, q);
            if (uf.getCount() < 2) {
                return uf.getCount();
            }
        }
        return uf.getCount() - 1;
    }
}

class UF2 {
    private int count;
    private int[] parent;

    public UF2(int n) {
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

    public void union(int p, int q) {
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
