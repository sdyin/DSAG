package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 977.有序数组的平方
 * //给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：[-4,-1,0,3,10]
 * //输出：[0,1,9,16,100]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：[-7,-3,2,3,11]
 * //输出：[4,9,9,49,121]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= A.length <= 10000
 * // -10000 <= A[i] <= 10000
 * // A 已按非递减顺序排序。
 * //
 * // Related Topics 数组 双指针
 * // 👍 160 👎 0
 * @Author liuye
 * @Date 2020/10/16 21:24
 **/
public class SortedSquares977 {

    /**
     * 冒泡排序复杂度 O(n*n) 待优化
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]) * Math.abs(A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = 0;
                    temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }

    /**
     * TODO 思考更优解决方式
     *
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {

        return null;
    }
}
