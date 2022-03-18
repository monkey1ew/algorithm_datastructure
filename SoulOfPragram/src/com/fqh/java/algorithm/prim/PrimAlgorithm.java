package com.fqh.java.algorithm.prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵 10000大数表示两个点不连通
        int[][] weight = new int[][] {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGraph mGraph = new MGraph(verxs);
        //MinTree
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, data, weight);
        minTree.showGraph(mGraph);

        //Prim
        minTree.prim(mGraph, 0);
    }

}

//创建最小生成树
class MinTree {
    //创建图的邻接矩阵
    /**
     * @param graph 图对象
     * @param verxs 顶点个数
     * @param data  顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) { //顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的方法
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //Prim算法
    /**
     * @param graph 图
     * @param v 从该顶点生成  'A' -> 0...
     */
    public void prim(MGraph graph, int v) {
        //标记顶点是否被访问
        boolean[] isVisited = new boolean[graph.verxs];

        isVisited[v] = true;
        //h1 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将minWeight初始大数
        for (int k = 1; k < graph.verxs; k++) { //prim生成 verxs - 1条边
            //每一次生成的子图 和 哪两个顶点的距离最近
            for (int i = 0; i < graph.verxs; i++) { //i顶点表示被访问过的顶点
                if (isVisited[i]){
                    for (int j = 0; j < graph.verxs; j++) { //j表示还没有访问过的顶点
                        if (!isVisited[j] && graph.weight[i][j] < minWeight) {
                            //替换minWeight
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
            }
            //找到一条
            System.out.println("边<"+ graph.data[h1] + "," + graph.data[h2] + "> 权值: " + minWeight);
            //标记已访问
            isVisited[h2] = true;
            //重置minWeight
            minWeight = 10000;

        }
    }
}

class MGraph {
    int verxs; //表示图的节点个数
    char[] data; //保存节点数据
    int[][] weight; //存放边, 邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
