package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description 插入排序示例
 * @Author liuye
 * @Date 2020/9/26 12:16
 **/
public class InsertSort {

    /**
     * 插入排序
     *
     * @param sourceArr
     * @return
     */
    public static int[] sort(int[] sourceArr) {

        for (int i = 1; i < sourceArr.length; i++) {
            int data = sourceArr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0 && data < sourceArr[j]) {
                    sourceArr = insert(sourceArr, i, j);
                }
                if (j > 0 && data < sourceArr[j] && data >= sourceArr[j - 1]) {
                    sourceArr = insert(sourceArr, i, j);
                }
            }
        }
        return sourceArr;
    }

    /**
     * 插入指定位置
     *
     * @param sourceArr
     * @param i
     * @param j
     * @return
     */
    private static int[] insert(int[] sourceArr, int i, int j) {
        int data = sourceArr[i];
        for (int k = i; k > j; k--) {
            sourceArr[k] = sourceArr[k - 1];
        }
        sourceArr[j] = data;
        return sourceArr;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 34, 56, 22, 8, 1, 46, 99};
        int[] result = insertSort(arrays);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


    /**
     * 插入排序方式二
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
