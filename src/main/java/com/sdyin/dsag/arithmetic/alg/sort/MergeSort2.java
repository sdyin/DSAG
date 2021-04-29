package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;


/**
 * @Description: 归并排序
 * @Author: liuye
 * @time: 2021/4/29$ 上午10:33$
 */
public class MergeSort2 {

    /**
     * 归并排序，先分割，再合并
     *
     * @param sourceArray
     * @return
     */
    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        //递归出口:元素只有1个时返回
        if (arr.length < 2) {
            return arr;
        }

        int middle = (int) Math.floor(arr.length / 2);

        //这里可以定义0，是因为每次传入的arr是变化的，针对的是每次递归的arr的0索引下标
        final int[] left = Arrays.copyOfRange(arr, 0, middle);
        final int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    /**
     * 合并
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0;
        while (left.length != 0 && right.length != 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                //left 移除当前已合并排序元素
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        //左右合并后左边剩余的直接加入排序结果集
        while (left.length != 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length != 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] sourceArray = {2,44,12,2,4,6,3,7};
        final int[] arr = sort(sourceArray);
        Arrays.stream(arr).forEach(item -> System.out.println(item));
    }
}
