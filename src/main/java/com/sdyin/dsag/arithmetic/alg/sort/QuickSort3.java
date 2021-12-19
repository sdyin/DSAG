package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/12/28$ 下午10:10$
 */
public class QuickSort3 {

    public static int[] sort(int[] arrays) {
        int[] arr = Arrays.copyOfRange(arrays, 0, arrays.length);
        arr = quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if(left < right){
            final int point = findPoint(arr, left, right);
            quickSort(arr, left, point - 1);
            quickSort(arr, point + 1, right);
        }
        return arr;
    }

    private static int findPoint(int[] arr, int left, int right) {
        //取最左值为基准值
        int temp =  arr[left];
        while (left < right){
            //此处是 arr[right] >= temp 而不是 arr[right] > temp
            // 因为如果基准值和当前值相等也需要转移的话，就会出现arr[left] 和 arr[right] 一直相互转换
            while (left < right && arr[right] >= temp){
                --right;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= temp){
                ++left;
            }
            arr[right] = arr[left];
        }

        arr[left] = temp;
        return left;
    }


    public static void main(String[] args) {
        int[] arr = {6, 1, 7, 2, 5, 32, 13, 8, 2};
        final int[] result = sort(arr);
        Arrays.stream(result).forEach(System.out::println);
    }


}
