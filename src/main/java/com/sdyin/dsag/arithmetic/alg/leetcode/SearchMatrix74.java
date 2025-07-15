package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）

 * 链接：URL_ADDRESS * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 * @Author: liuye
 * @time: 2025/7/15$ 14:40$
 */
public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 将行进行二分查找：查找到对应行
        int topRow = 0;
        int bottomRow = m - 1;

        while (topRow <= bottomRow) {
            int midRow = topRow + (bottomRow - topRow) / 2;
            // 目标数据行匹配
            if (matrix[midRow][0] <= target && target <= matrix[midRow][n - 1]) {
                // 找到目标行，进行第二次二分查找
                return binarySearchInRow(matrix[midRow], target);
            } else if (matrix[midRow][0] > target) {
                // 目标值小于当前行最小值，说明目标值在当前行的上面
                bottomRow = midRow - 1;
            } else {
                // 目标值大于当前行最大值，说明目标值在当前行的下面
                topRow = midRow + 1;
            }
        }

        return false;
    }

    private boolean binarySearchInRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
