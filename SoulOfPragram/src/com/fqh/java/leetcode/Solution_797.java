package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 797. 所有可能的路径
 */
public class Solution_797 {

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> path = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(graph, 0, path, list);
        return path;
    }

    public static void dfs(int[][] graph, int start, List<List<Integer>> path, List<Integer> list) {
        list.add(start);
        while (start == graph.length - 1) {
            path.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int v : graph[start]) {
            dfs(graph, v, path, list);
        }
        list.remove(list.size() - 1);
    }
}
