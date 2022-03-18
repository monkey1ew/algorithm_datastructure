package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 1584. 连接所有点的最小费用 (Prim)
 */
public class Solution_1584 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3,10}, {5, 2}, {7, 0}};
        System.out.println("最小生成树的权值 = " + minCostConnectPoints(points));
    }
    //prim
    public static int minCostConnectPoints(int[][] points) {
        boolean[] isVisited = new boolean[points.length];
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E'};
        int minWeight = Integer.MAX_VALUE;
        int[][] ints = helper(points);

        isVisited[0] = true;
        int h1 = -1;
        int h2 = -1;
        int sum = 0;
        for (int k = 1; k < points.length; k++) {
            for (int i = 0; i < points.length; i++) {
                if (isVisited[i]) {
                    for (int j = 0; j < points.length; j++) {
                        if (!isVisited[j] && ints[i][j] < minWeight) {
                            minWeight = ints[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
            }
            System.out.println("<" + data[h1] + "," + data[h2] + ">" + "权值 = " + minWeight);
            sum += minWeight;
            isVisited[h2] = true;
            minWeight = Integer.MAX_VALUE;
        }
        return sum;
    }

    public static int[][] helper(int[][] points) {
        int[][] res = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                res[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

            }
        }
        return res;
    }
}
