package com.fqh.java.leetcode;

import java.net.URL;

/**
 * @author 海盗狗
 * @version 1.0
 * 323. 无向图中连通分量的数目
 */
public class Solution_323 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        UnF uf = new UnF(n);

        for (int[] link : edges) {
            int p = link[0];
            int q = link[1];
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
        }
        return uf.getCount();
    }
}

class UnF {
    private int count;
    private int[] parent;

    public UnF(int n) {
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

    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    public int getCount() {
        return count;
    }
}
