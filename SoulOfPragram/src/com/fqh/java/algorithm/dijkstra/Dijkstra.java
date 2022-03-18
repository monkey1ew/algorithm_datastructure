package com.fqh.java.algorithm.dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Dijkstra {
    static List<Integer>[] graph;
    public static void main(String[] args) {
        graph = new List[5];

    }

    public static int[] dijkstra(int start, List<Integer>[] graph) {
        //图中节点的个数
        int v = graph.length;
        ///记录最短路径的权重
        //disTo[i]的值, 就是start 到节点 i的最短路径的权重
        int[] disTo = new int[v];
        //初始化
        Arrays.fill(disTo, Integer.MAX_VALUE);
        disTo[start] = 0; //start -> start = 0;

        //优先队列, disFromStart 小的排在队列前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        //从start 开始bfs
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > disTo[curNodeID]) {
                //已经有一条更短的路径到达 curNode节点
                continue;
            }
            //将curNode相邻的节点加入队列
            for (int nextNodeID : adj(curNodeID)) {
                //查看curNode 达到 nextNode 的距离是否会更短
                int distToNextNode = disTo[curNodeID] + weight(curNodeID, nextNodeID);
                if (disTo[nextNodeID] > distToNextNode) {
                    //刷新距离表
                    disTo[nextNodeID] = distToNextNode;
                    //将这个节点及距离放入队列
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return disTo;
    }

    public static int weight(int from, int to) {
        return graph[from].get(to);
    }
    //返回s相邻的节点
    public static List<Integer> adj(int s) {
        return graph[s];
    }
}

class State {
    //图节点的id
    int id;
    //从start 节点 到当前节点的距离
    int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
