package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer II 110. 所有路径
 */
public class Solution_110_ {

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
            list.remove(list.size() - 1); //删除list的末尾元素
            return;
        }

        for (int v : graph[start]) {
            dfs(graph, v, path, list); //遍历start的邻接表[路径]
        }

        list.remove(list.size() - 1);
    }
}
