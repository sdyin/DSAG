package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * 最好时间复杂度O(n)，最坏时间复杂度O(n的平方)
 * @Author: liuye
 * @time: 2022/3/18$ 8:51 上午$
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {12, 66, 33, 23, 78, 33, 68};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        Arrays.stream(arr).forEach(item -> System.out.println(item));
    }
}
