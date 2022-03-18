package com.fqh.java.algorithm.floyd;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version
 */
public class FloydAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;
        int[][] matrix = new int[][]{
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N ,N ,8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}
        };
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.show();
        graph.floyd();
        System.out.println("**************FLOYD****************");
        graph.show();
    }

}

class Graph {
    private char[] vertex; //顶点
    private int[][] dis; //最短距离表(各个顶点到其他顶点的最短路)
    private int[][] pre; //保存到达目标顶点的前驱顶点 A ——> B ——> C , B的pre ——>A

    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        //初始化pre,存放前驱顶点的下标
        for (int i = 0; i < pre.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void show() {
        for (int[] link : dis) {
            System.out.println(Arrays.toString(link));
        }
        System.out.println("****************************");
        for (int[] link : pre) {
            System.out.println(Arrays.toString(link));
        }
    }

    //floyd
    public void floyd() {
        int len = 0; //记录变量保存距离

        //中间顶点 : k
        for (int k = 0; k < dis.length; k++) {
            //从i 出发到 k
            for (int i = 0; i < dis.length; i++) {
                // 从k 出发到 j
                for (int j = 0; j < dis.length; j++) {
                    if (dis[i][k] == 65535 || dis[k][j] == 65535) {
                        continue;
                    }
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }
}