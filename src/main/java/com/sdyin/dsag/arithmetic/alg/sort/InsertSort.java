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
            for (int j = i-1; j >= 0; j--) {
                if(j == 0 && data < sourceArr[j]){
                    sourceArr = insert(sourceArr, i, j);
                }
                if(j > 0 && data < sourceArr[j] && data >= sourceArr[j - 1]){
                    sourceArr = insert(sourceArr, i, j);
                }
            }
        }
        return sourceArr;
    }

    /**
     * 插入指定位置
     * @param sourceArr
     * @param i
     * @param j
     * @return
     */
    private static int[] insert(int[] sourceArr, int i, int j) {
        int data = sourceArr[i];
        for (int k = i; k > j; k--) {
            sourceArr[k] = sourceArr[k-1];
        }
        sourceArr[j] = data;
        return sourceArr;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 34, 56, 22, 8, 1, 46, 99};
        int[] result = sort(arrays);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
