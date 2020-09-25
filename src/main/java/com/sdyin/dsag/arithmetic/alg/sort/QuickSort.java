package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * 分治思想
 * 快速排序: 时间复杂度 nlogn
 * 快速排序的本质就是把 基准数大的都放在基准数的左边(不一定完全有序)
 * 把比基准数小的放在基准数的右边,这样就找到了该数据在数组中的正确位置(重要).
 * 然后递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
 * @Description
 * @Author liuye
 * @Date 2019/8/22 14:58
 */
public class QuickSort {


    public static int[] sort(int[] arrays) {
        int[] arr = Arrays.copyOf(arrays, arrays.length);
        return quickSort(arr, 0, arr.length - 1);

    }

    /**
     * 递归方法 快速排序
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    //此种方式为挖坑填数方式
    private static int partition(int[] arr, int low, int high) {
        // 设定基准值（pivot）,初始取最左元素
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];

            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        // 返回tmp的正确位置
        return low;


    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arrays = {1,34,56,22,8,1,46,99};
        int[] result = sort(arrays);
        for (int i = 0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}
