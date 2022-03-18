package com.fqh.java.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0 迪杰斯特拉算法
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535; //表示不连接
        int[][] matrix = new int[][] {
                /** A, B, C, D, E, F, G*/
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N ,N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();

        graph.dsj(6);
    }
}


class Graph {
    private char[] vertex; //顶点数组, 'A','B'...
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    //dijkstra
    /**
     * @param index 出发顶点的下标
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index); //更新index顶点到周围顶点的距离和前驱表

        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr(); //选择并返回新的访问顶点
            update(index);
        }
        vv.show();
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
    private void update(int index) {
        int len = 0;
        //遍历起点, 刷新距离表
        for (int j = 0; j < matrix[index].length; j++) {
            //出发点到index的距离 + index到j顶点的距离
            len = vv.getDis(index) + matrix[index][j];
            //如果j顶点没有被访问过, 并且len < 出发点到j顶点的距离, 刷新距离表
            if (!vv.in(j) && len < vv.getDis(j)) {
                 vv.updatePre(j, index); //更新j顶点的前驱节点
                 vv.updateDis(j, len); //刷新距离
            }
        }
    }
}

class VisitedVertex {
    //记录各个顶点是否已访问
    public int[] isVisited;
    //记录每一个顶点的前驱顶点的下标
    public int[] pre_Visited;
    //距离表
    public int[] dis;

    /**
     * @param length 顶点的个数
     * @param index  出发点对应的下标 , 'G' ——> 6
     */
    public VisitedVertex(int length, int index) {
        this.isVisited = new int[length];
        this.pre_Visited = new int[length];
        this.dis = new int[length];
        //初始化dis
        Arrays.fill(dis, 65535);
        this.isVisited[index] = 1; //设置出发顶点被访问
        this.dis[index] = 0; //自己为0
    }

    /**
     * 判断index顶点是否被访问过
     *
     * @param index 1
     * @return boolean
     */
    public boolean in(int index) {
        return isVisited[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len   长度
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新顶点的前驱为pre的节点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_Visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     *
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    //选择下一个访问点
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新index被访问
        isVisited[index] = 1;
        return index;
    }

    //显示最后结果
    public void show() {
        for (int i : isVisited) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : pre_Visited) {
            System.out.print(i + " ");
        }
        System.out.println();
//        for (int i : dis) {
//            System.out.print(i + " ");
//        }

        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count++] + "("+ i + ")");
            }else {
                System.out.print("N");
            }
        }
    }
}