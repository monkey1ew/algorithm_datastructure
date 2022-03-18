package com.fqh.java.leetcode;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 12. 矩阵中的路径
 */
public class Solution_12_12 {
    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a','b'},{'c','d'}};
//        String word = "";
        String word = "abcd";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if(board.length < 2 && board[0].length < word.length()) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, isVisited, i, j, 0)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word,
                       boolean[][] isVisited, int row, int col, int index) {
        if (col < 0 || row > board.length - 1 || row < 0 || col > board[0].length - 1
                || isVisited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        isVisited[row][col] = true;
        if (index == word.length() - 1) {
            return true;
        }
        boolean loop = dfs(board, word, isVisited, row - 1, col, index + 1) ||
                dfs(board, word, isVisited, row, col + 1, index + 1) ||
                dfs(board, word, isVisited, row + 1, col, index + 1) ||
                dfs(board, word, isVisited, row,  col - 1, index + 1);
        isVisited[row][col] = false;
        return loop;
    }
}
