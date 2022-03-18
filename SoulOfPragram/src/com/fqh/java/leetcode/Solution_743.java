package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 743. 网络延迟时间 ——> dijkstra
 */
public class Solution_743 {

    public static void main(String[] args) {
        int[][] times = new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[] {to, weight});
        }
        int[] distTo = dijkstra(graph, k);
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        System.out.println(Arrays.toString(distTo));
        return res;
    }

    public static int[] dijkstra(List<int[]>[] graph, int start) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State curNode = pq.poll();
            int curNodeID = curNode.id;
            int curDistFromStart = curNode.distFromStart;
            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }
            for (int[] nextNode : graph[curNodeID]) {
                int nextNodeID = nextNode[0];
                int distToNextNode = distTo[curNodeID] + nextNode[1];
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}

class State {
    int id;
    int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}