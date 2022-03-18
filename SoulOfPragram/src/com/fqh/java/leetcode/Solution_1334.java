package com.fqh.java.leetcode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 1334. 阈值距离内邻居最少的城市
 */
public class Solution_1334 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2},
                {2, 3, 1}, {3, 4, 1}
        };
        System.out.println(findTheCity(5, edges, 2));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = helper(edges, n);
        return floyd(graph, distanceThreshold);
    }

    public static int floyd(int[][] graph, int distanceThreshold) {

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[j][k]);
                }
            }
        }
        System.out.println("****************************");
        for (int[] link : graph) {
            System.out.println(Arrays.toString(link));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    list.add(graph[i][j]);
                    map.put(i, list);
                }
            }
        }
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> {
            if (o1.getValue().size() == o2.getValue().size()) {
                return o2.getKey() - o1.getKey();
            }else {
                return o1.getValue().size() - o2.getValue().size();
            }
        }));
        System.out.println(list);
        return list.get(0).getKey();
    }

    public static int[][] helper(int[][] edges, int n) {
        final int INF = Integer.MAX_VALUE;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = INF;
            }
        }
        for (int[] link : edges) {
            int i = link[0];
            int j = link[1];
            int weight = link[2];
            graph[i][j] = weight;
            graph[j][i] = weight;
        }
        return graph;
    }
}
