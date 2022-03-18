package com.fqh.java.leetcode;

import javax.xml.soap.SOAPMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1101. 彼此熟识的最早时间
 */
public class Solution_1101 {

    public static void main(String[] args) {
        int[][] logs = new int[][]{{20190101, 0, 1}, {20190104, 3, 4},
                {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3},
                 {20190312,1,2},{20190322,4,5}};
        System.out.println(earliestAcq(logs, 6));
    }

    public static int earliestAcq(int[][] logs, int n) {
        UFind uf = new UFind(n);
        List<int[]> list = new ArrayList<>();
        for (int[] link : logs) {
            list.add(link);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] link : list) {
            int p = link[1];
            int q = link[2];

            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            if (uf.getCount() < 2) {
                return link[0];
            }
        }
        return -1;
    }

}

class UFind {
    private int[] parent;
    private int count;

    public UFind(int n) {
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
