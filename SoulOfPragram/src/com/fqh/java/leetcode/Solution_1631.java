package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1631. 最小体力消耗路径
 */
public class Solution_1631 {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        List<int[]> list = new ArrayList<>();
        Union_F uf = new Union_F(heights.length);
        for (int[] link : heights) {
            list.add(new int[] {link[0], link[1], Math.abs(link[0] - link[1])});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        int weight = 0;
        for (int[] link : list) {
            int p = link[0];
            int q = link[1];
            weight = link[2];

            if (uf.isConnected(p, q)) {
                continue;
            }

            uf.union(p, q);
        }
        return weight;
    }

}

class Union_F {
    private int[] parent;

    public Union_F(int n) {
        this.parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
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
    }
    public boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }
}
