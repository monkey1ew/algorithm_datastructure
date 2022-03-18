package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1135. 最低成本联通所有城市 ----------> Kruskal
 * 输入：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
 * 输出：6
 * 解释：
 * 选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
 */
public class Solution_1135 {

    public static void main(String[] args) {
//        int[][] connections = new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int[][] connections = new int[][]{{1,2,3}, {3,4,4}};
        System.out.println(minimumCost(4, connections));
    }


    public static int minimumCost(int n, int[][] connections) {
        UnionF unionF = new UnionF(n);
        List<int[]> list = new ArrayList<>();
        for (int[] link : connections) {
            list.add(link);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int sum = 0;
        for (int[] link : list) {
            int p = link[0];
            int q = link[1];
            int weight = link[2];

            if (unionF.connected(p, q)) {
                continue;
            }
            unionF.union(p, q);
            sum += weight;
        }
        if (unionF.getCount() > 2) {
            return -1;
        }
        return sum;
    }

}

class UnionF {

    private int[] parent;
    private int count;

    public UnionF(int n) {
        this.count = n + 1;
        this.parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
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
