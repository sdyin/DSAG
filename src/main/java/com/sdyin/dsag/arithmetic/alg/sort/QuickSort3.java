package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/12/28$ 下午10:10$
 */
public class QuickSort3 {

    public static int[] sort(int[] arrays) {
        int[] arr = Arrays.copyOf(arrays, arrays.length);
        arr = quickSort(arr, 0, arrays.length - 1);
        return arr;
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right){
            //寻找通过的
            int point = findPoint(arr, left,right);
            quickSort(arr, left, point - 1);
            quickSort(arr, point+1, right);
        }
        return arr;
    }

    private static int findPoint(int[] arr, int low, int high) {
        int temp = arr[low];
        while(low < high){
            while(low < high && arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] >= temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {6,1,7,2,5,32,13,8,2};
        final int[] result = sort(arr);
        for (int i = 0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }


}
