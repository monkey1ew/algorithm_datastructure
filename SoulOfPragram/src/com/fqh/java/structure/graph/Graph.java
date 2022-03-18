package com.fqh.java.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 比奇堡海滩
 * @version 1.0
 * 图
 */
public class Graph {

    private ArrayList<String> vertexList; //存储顶点
    private int[][] edges; //存储图对应的领结矩阵
    private int numOfEdges; //表示边的数目
    //定义boolean[]数组, 记录是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        //Test
        int n = 5; //节点的个数
        String VertexValue[] = {"A", "B", "C", "D", "E"};

        //创建图对象

        Graph graph = new Graph(5);
        //循环添加顶点
        for (String value : VertexValue) {
            graph.insertVertex(value);
        }
        //添加边
        //A-B, A-C, B-C, B-D, B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();

//        System.out.println("DFS-------------------------");
//        graph.dfs();

        System.out.println("BFS--------------------------");
        graph.bfs();
    }

    //构造器
    public Graph(int n) {
        //初始化 矩阵和arraylist
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    //得到第一个邻接节点的下标 w
    /**
     * @param index
     * @return 如果存在就返回对应下标, 否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //DFS
    //i 第一次就是0
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将该节点设置为已经访问
        isVisited[i] = true;
        //得到第一个邻接节点的下标 w
        int w = getFirstNeighbor(i);
        while (w != -1) { //说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w 已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //广度优先遍历,bfs
    private void bfs(boolean[] isVisited, int i) {
        int u; //表示队列的头节点的下标
        int w; //邻接节点的下标
        //队列, 节点访问顺序
        Queue<Integer> queue = new LinkedList<>();
        //访问节点
        System.out.print(getValueByIndex(i) + "->");
        //标记已访问
        isVisited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty()) {
            //取出队列的头
            //得到第一个邻接点的下标
            u = queue.poll();
            w = getFirstNeighbor(u);
            while(w != -1) { //找到
                //判断是否访问
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已访问
                    isVisited[w] = true;
                    //入队列
                    queue.offer(w);
                }
                //找到以u这一行的w的下一个节点
                w = getNextNeighbor(u, w); //bfs
            }
        }
    }

    //遍历所有的节点都进行bfs
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


    //对dfs进行重载, 遍历所有的节点进行 dfs
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //图中常用的方法
    //(1)返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //(2)得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //(3)返回节点i(下标)对应的值 0 ->"A", 1 -> "B" ....
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * @param v1     表示点的下标 (第几个顶点) "A" "B" "A" -> 0, "B" -> 1.
     * @param v2     第二个顶点对应的下标
     * @param weight 表示值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
