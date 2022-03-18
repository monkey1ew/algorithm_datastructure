package com.fqh.java.algorithm.kruskal;

import org.junit.jupiter.api.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class KruskalCase {

    private int edgeNum; //边的个数
    private char[] vertexs; //顶点的数组
    private int[][] matrix; //邻接矩阵
    //INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalCase kruskalCase = new KruskalCase(vertexes, matrix);
        kruskalCase.print();

        EData[] edges = kruskalCase.getEdges();
        System.out.println("排序前 = "+ Arrays.toString(edges));
        System.out.println("**************************************");
        kruskalCase.sortEdges(edges);
        System.out.println("排序后 =" + Arrays.toString(edges));
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length; //顶点个数

        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        this.matrix = matrix;
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0; //最后结果数组的索引
        int[] ends = new int[edgeNum]; //保存已有最小生成树中的每个顶点在最小生成树中的终点
        //创建结果数组, 保存最后的最小生成树
        EData[] results = new EData[edgeNum];

        //获取图中所有的边的集合
        EData[] edges = getEdges();
//        System.out.println("获取图的边 = " +Arrays.toString(edges));
        //1.排序边
        sortEdges(edges);

        //遍历edges, 将边添加到最小生成树, 判断是否构成回路
        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int p1Root = getEnd(ends, p1);
            int p2Root = getEnd(ends, p2);
            //判断是否构成回路
            if (p1Root != p2Root) { //不构成回路
                ends[p1Root] = p2Root; //设置p1Root在已有最小生成树的终点
                results[index++] = edges[i]; //加入
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(results[i]);
//            System.out.println("最小生成树 = " + Arrays.toString(results));
        }
    }

    public void print() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    //对边进行排序
    /**
     * @param edges 边的集合
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }
    /**
     * @param ch 顶点的值, 'A', 'B'
     * @return 返回 ch对应的下标
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边, 放入EData[] 遍历该数组
     * 通过matrix邻接矩阵
     * EData[] [['A', 'B', 12], ....]
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i 的顶点的终点, 判断两个顶点的终点是否相同
     * @param ends 记录了各个顶点对应的终点
     * @param i 表示传入顶点对应的下标
     * @return 返回下标为i的顶点对应终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

//边类EData, 表示一条边
class EData {
    char start; //边的起点
    char end; //边的终点
    int weight; //权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData[<" + start +
                "," + end +
                ">, weight=" + weight +
                ']';
    }
}
