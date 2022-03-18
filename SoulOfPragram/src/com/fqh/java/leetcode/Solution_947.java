package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 947. 移除最多的同行或同列石头
 */
public class Solution_947 {

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        U_F uf = new U_F(stones.length);
        for (int[] link : stones) {
            int p = link[0];
            int q = link[1];
            if (uf.isConnected(p, q)) {
                continue;
            }
            uf.union(p, q);
        }
        return uf.getCount();
    }
}

class U_F {
    private int count;
    private int[] parent;

    public U_F(int n) {
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
