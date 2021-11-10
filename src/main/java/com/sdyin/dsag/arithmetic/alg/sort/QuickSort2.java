package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: liuye
 * @time: 2020/11/2$ 下午9:45$
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 2, 5, 42, 56, 8, 4, 6, 7, 2, 2, 6, 3, 6, 11, 34};
        int[] result = quickSort(arr, 0, arr.length - 1);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = findPivot(arr, left, right);
            // 左右需要间隔基准值所在下标索引，不然每次
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
        return arr;
    }

    private static int findPivot(int[] arr, int left, int right) {
        //默认初始最左为基准值
        int tmp = arr[left];
        while (left < right) {
            //满足条件,则移动指针位置
            while (left < right && arr[right] >= tmp) {
                --right;
            }
            //不满足条件时,即右节点当前值转移到左边。
            arr[left] = arr[right];

            while (left < right && arr[left] <= tmp) {
                ++left;
            }
            arr[right] = arr[left];
        }

        arr[left] = tmp;
        return left;
    }
}
