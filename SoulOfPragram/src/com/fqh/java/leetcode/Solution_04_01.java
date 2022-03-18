package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 面试题 04.01. 节点间通路
 */
public class Solution_04_01 {
    static boolean hasPath = false;

    public static void main(String[] args) {

        int[][] graph = new int[][] {
                {0,1},{0,2},{1,2},{1,2}
        };
        int start = 0;
        int target = 2;
        int n = 3;

        System.out.println(findWhetherExistsPath(n, graph, start, target));
    }

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] graph1 = buildGraph(graph);
        boolean[] onPath = new boolean[n];
        backtrack(graph1, start, target, onPath);
        return hasPath;
    }
    public static void backtrack(List<Integer>[] graph, int start, int target, boolean[] onPath) {
//        形成环
        if (onPath[start]) {
            return;
        }
//        找到路
        if (start == target) {
            hasPath = true;
            return;
        }
//        出发标记
        onPath[start] = true;
        for (int t : graph[start]) {
            backtrack(graph, t, target, onPath);
        }
//        回来撤销标记
        onPath[start] = false;
    }

    public static List<Integer>[] buildGraph(int[][] arr) {
        List<Integer>[] graph = new LinkedList[arr.length];
        for (int i = 0; i < arr.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] link : arr) {
            int form = link[0];
            int to = link[1];
            graph[form].add(to);
        }
        return graph;
    }
}
