package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 79.单词搜索
 * //给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * //
 * // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * //
 * //
 * //
 * // 示例:
 * //
 * // board =
 * //[
 * //  ['A','B','C','E'],
 * //  ['S','F','C','S'],
 * //  ['A','D','E','E']
 * //]
 * //
 * //给定 word = "ABCCED", 返回 true
 * //给定 word = "SEE", 返回 true
 * //给定 word = "ABCB", 返回 false
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // board 和 word 中只包含大写和小写英文字母。
 * // 1 <= board.length <= 200
 * // 1 <= board[i].length <= 200
 * // 1 <= word.length <= 10^3
 * //
 * // Related Topics 数组 回溯算法
 * // 👍 726 👎 0
 * @Author: liuye
 * @time: 2020/12/29$ 下午3:05$
 */
public class ExistWord79 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param word
     * @param i
     * @param j
     * @param index 表示查找到字符串word的第几个字符
     * @return
     */
    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界判断
        //board[i][j] != word[index] 第一个字符不匹配，直接false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]) {
            return false;
        }
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1) {
            return true;
        }
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值，相当于标记，不让重新退回。相当于标记哪些已经走过
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }


    public static void main(String[] args) {

    }
}
