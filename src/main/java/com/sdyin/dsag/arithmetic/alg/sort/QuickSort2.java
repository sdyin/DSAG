package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: liuye
 * @time: 2020/11/2$ 下午9:45$
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int arr[] = {10,7,8,2,5,3,6,11,34};
        sort(arr);
    }

    public static void sort(int[] arr){

        int[] result = quickSort(arr, 0, arr.length -1);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right){
            //寻找基准点
           int pivot = findPivot(arr, left, right);
           quickSort(arr, left, pivot - 1);
           quickSort(arr, pivot + 1, right);
        }
        return arr;
    }

    private static int findPivot(int[] arr, int left, int right) {
        //假设最左为基准点
        int pivot = arr[left];
        while (left < right){

            //注意，基准值采用最左元素时，应该先移动右边
            //如果先移动左边，出现第一个不满足情况时(即要替换元素)，基准值会移动替换到右边
            while(arr[right] >= pivot && left < right){
                right--;
            }
            //右边数据小于基准值时，交换到左边
            arr[left] = arr[right];

            while(arr[left] <= pivot && left < right){
                left++;
            }
            //左边数据大于pivot时，交换到右边
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
