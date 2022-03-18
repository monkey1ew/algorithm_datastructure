package com.fqh.java.leetcode;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 130. 被围绕的区域
 */
public class Solution_130 {

    public static void main(String[] args) {

        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };

        char[][] graph = {
                {'X','O','X'},
                {'O','X','O'},
                {'X','O','X'}
        };
        solve(graph);
        for (char[] link : graph) {
            System.out.println(Arrays.toString(link));
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
//        将四周有’O’的和‘O’相连的全部染成'-'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //        将里面的还有'O'的染成‘X’
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                    continue;
                }
//                将所以的‘-’还原
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }
        if (board[row][col] == 'X' || board[row][col] == '-') {
            return;
        }
        board[row][col] = '-';
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
    }
}
