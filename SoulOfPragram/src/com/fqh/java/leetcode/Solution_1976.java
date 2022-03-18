package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 1976. 到达目的地的方案数
 */
public class Solution_1976 {

    public static void main(String[] args) {
        int[][] roads = new int[][]{{0, 6, 7},
                {0, 1, 2}, {1, 2, 3}, {1, 3, 3}
                , {6, 3, 3}, {3, 5, 1}, {6, 5, 1},
                {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(countPaths(7, roads));
    }


    public static int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] link : roads) {
            int from = link[0];
            int to = link[1];
            int weight = link[2];
            graph[from].add(new int[]{to, weight});
        }
        int[] dis = dijkstra(graph, 0);
        int[] dis2 = dijkstra(graph, 1);
        System.out.println(Arrays.toString(dis2));
        int num = 0;

        return num;
    }

    public static int[] dijkstra(List<int[]>[] graph, int start) {

        int[] dis = new int[graph.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curNode = pq.poll();
            int curNodeID = curNode.id;
            int curDistFromStart = curNode.distFromStart;
            if (curDistFromStart > dis[curNodeID]) {
                continue;
            }
            for (int[] next : graph[curNodeID]) {
                int nextNodeID = next[0];
                int distToNextNode = dis[curNodeID] + next[1];
                if (dis[nextNodeID] > distToNextNode) {
                    dis[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return dis;
    }
}


