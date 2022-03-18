package com.fqh.java.algorithm.recursion;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class MiGong {

    public static void main(String[] args) {
        //二维数组模拟你迷宫
        int[][] map = new int[8][7]; //8行7列
        //使用1表示墙
        //把上下置为一
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }


        //左右全部为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置障碍
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay5(map, 1, 1);
        int count = 0;
        System.out.println("找到路后---------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if(map[i][j] == 2){
                    count++;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(count);


    }

    //使用递归回溯给小球找路
    //1. map表示地图
    //2. i j 表示从地图哪个位置开始出发
    //3. 如果小球能到map的【6】【5】则说明找到路了
    //4. 当地图的map[i][j] 为 0时,表示该点没有走过,
    // 当为1时表示 , 为2表示可以在, 为3表示已经走过但是走不通
    //5. 在走迷宫时, 需要定制一个策略 下--->右---->上----->左;[走不同再回溯]
    /**
     *
     * @param map 地图
     * @param i   从那个位置开始找
     * @param j
     * @return   找到路就放true;
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){ //已经找到
            return true;
        }else {
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                //策略 下--->右---->上----->左;[走不同再回溯]
                map[i][j] = 2; //假定该点能走通
                if (setWay(map, i + 1, j)){ //向下走
                    return true;
                }else if(setWay(map, i, j+1)){ //向右
                    return true;
                }else if (setWay(map, i-1, j)){ //向上
                    return true;
                }else if (setWay(map, i, j-1)){ //向左
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果map[i][j] != 0; 可能是1, 2, 3
                return false;
            }
        }
    }
    public static boolean setWay2(int[][] map, int i, int j){
        if (map[6][5] == 2){ //已经找到
            return true;
        }else {
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                //策略 下--->右---->上----->左;[走不同再回溯]
                map[i][j] = 2; //假定该点能走通
                if (setWay2(map, i - 1, j)){ //向上走
                    return true;
                }else if(setWay2(map, i, j+1)){ //向右
                    return true;
                }else if (setWay2(map, i + 1, j)){ //向下
                    return true;
                }else if (setWay2(map, i, j-1)){ //向左
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果map[i][j] != 0; 可能是1, 2, 3
                return false;
            }
        }
    }

    public static boolean setWay4(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //已经找到
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                //策略 下--->右---->上----->左;[走不同再回溯]
                map[i][j] = 2; //假定该点能走通
                if (setWay4(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay4(map, i, j - 1)) { //向左
                    return true;
                } else if (setWay4(map, i + 1, j)) { //向下
                    return true;
                } else if (setWay4(map, i, j + 1)) { //向右
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0; 可能是1, 2, 3
                return false;
            }
        }
    }

    //修改找路的策略
    public static boolean setWay3(int[][] map, int i, int j){
        if (map[6][5] == 2){ //已经找到
            return true;
        }else {
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                //策略 下--->右---->上----->左;[走不同再回溯]
                map[i][j] = 2; //假定该点能走通
                if (setWay3(map, i - 1, j)){ //向下走
                    return true;
                }else if(setWay3(map, i, j-1)){ //向左
                    return true;
                }else if (setWay3(map, i + 1, j)){ //向上
                    return true;
                }else if (setWay3(map, i, j+1)){ //向右
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果map[i][j] != 0; 可能是1, 2, 3
                return false;
            }
        }
    }

    public static boolean setWay5(int[][] map, int i, int j){
        if (map[6][5] == 2){ //已经找到
            return true;
        }else {
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                //策略 下--->右---->上----->左;[走不同再回溯]
                map[i][j] = 2; //假定该点能走通
                if (setWay5(map, i, j - 1)){ //向右
                    return true;
                }else if(setWay5(map, i - 1, j)){ //向上
                    return true;
                }else if (setWay5(map, i, j + 1)){ //向左
                    return true;
                }else if (setWay5(map, i + 1, j)){ //向下
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果map[i][j] != 0; 可能是1, 2, 3
                return false;
            }
        }
    }
}
