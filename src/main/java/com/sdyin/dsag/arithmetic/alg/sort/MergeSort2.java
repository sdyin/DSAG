package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;


/**
 * @Description: 归并排序: 先拆分，拆分到最细粒度时再合并
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

        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }

        int middle = (int) Math.floor(arr.length / 2);

        //拆分
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
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
        //合并比较
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
            i++;
        }

        while (left.length > 0) {
            result[i] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
            i++;
        }

        while (right.length > 0) {
            result[i] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] sourceArray = {2, 44, 12, 2, 4, 6, 3, 7};
        int[] arr = sort(sourceArray);
        Arrays.stream(arr).forEach(item -> System.out.println(item));
    }
}
