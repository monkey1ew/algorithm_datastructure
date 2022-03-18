package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1584. 连接所有点的最小费用 (Kruskal)
 */
public class Solution_1584_ {

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                list.add(new int[] {i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        UF uf = new UF(points.length);
        int sum = 0;
        for (int[] link : list) {
            int p = link[0];
            int q = link[1];
            int weight = link[2];
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            sum += weight;
        }
        return sum;
    }
}

//并查集类, kruskal判断是否形成回路
class UF {

    private int[] parent; //节点x的父节点是parent[x]

    public UF(int n) {
        //父节点初始指向自己
        parent = new int[n];
        for (int i = 0; i < n; i++) {
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
