package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 51.N 皇后
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/19$ 8:35 下午$
 */
public class SolveNQueens51 {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        //初始化空棋盘
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * 一行一行选择
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        //匹配到最终条件,当board每一行都匹配元素时
        if(row == board.length){
            res.add(charToList(board));
            return;
        }
        int n = board[row].length;
        //遍历其他节点(类似遍历多叉树其他节点)
        for(int col = 0; col < n; col++){
            //节点无效 则跳过这次循环
            if(!isValid(board, row, col)){
                continue;
            }

            //选择当前节点为皇后
            board[row][col] = 'Q';
            //递归下一层选择皇后
            backtrack(board, row + 1);

            //撤销当前选择
            board[row][col] = '.';
        }
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    /**
     * 判断是否有效
     * 因为皇后是一行一行从上往下放的，所以左下方，右下方和正下方不用检查（还没放皇后）；
     * 因为一行只会放一个皇后，所以每行不用检查。
     * 也就是最后只用检查上面，左上，右上三个方向。
     * @param board
     * @param row
     * @param col
     * @return
     */
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
