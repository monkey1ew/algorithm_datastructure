package com.fqh.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 207. 课程表
 */
public class Solution_207 {
    static boolean hasCycle;
    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        int numCourse = 2;

        System.out.println(canFinish(numCourse, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] isVisited = new boolean[numCourses];
        dfs(graph, isVisited, 0);
        return !hasCycle;
    }

    public static void dfs(List<Integer>[] graph, boolean[] isVisited, int start) {
        if (isVisited[start]) {
            hasCycle = true;
            return;
        }
        if (hasCycle) {
            return;
        }
        isVisited[start] = true;
        for (int t : graph[start]) {
            dfs(graph, isVisited, t);
        }
        isVisited[start] = false;
    }

    //    构建邻接表
    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] link : prerequisites) {
            int from = link[1];
            int to = link[0];
            graph[from].add(to);
        }
        return graph;
    }
}
