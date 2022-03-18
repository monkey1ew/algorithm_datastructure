package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1557. 可以到达所有点的最少点数目
 */
public class Solution_1557 {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(5);
        List<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(4);
        list5.add(2);
        System.out.println(findSmallestSetOfVertices(6, graph));
    }


    public static List<List<Integer>> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isVisited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> path = new ArrayList<>();
        dfs(edges, 0, path, list, isVisited, n - 1);
        return path;
    }

    public static void dfs(List<List<Integer>> graph, int start, List<List<Integer>> path, List<Integer> list, boolean[] isVisited, int end) {
        list.add(start);
        while (start == graph.size()) {
            path.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for (int v : graph.get(start)) {
            dfs(graph, v, path, list, isVisited, end);
        }
        list.remove(list.size() - 1);
    }
}
