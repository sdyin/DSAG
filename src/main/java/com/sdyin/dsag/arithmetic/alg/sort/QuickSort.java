package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * 分治思想
 * 快速排序: 平均 O (n log n)，最坏 O (n²)（需合理选择基准值避免）
 * 不稳定排序
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
            // 找到基准值，基准值左边的都小于基准值，右边的都大于基准值
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            // 右节点需要间隔基准值所在下标索引 + 1，不然每次右节点会死循环递归
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    //此种方式为挖坑填数方式
    private static int partition(int[] arr, int low, int high) {
        // 设定基准值（pivot）,初始取最左元素
        int tmp = arr[low];
        while (low < high) {

            //这里注意 为什么需要先从右侧开始判断，再从左侧开始？
            // 因为现在取的基准点是最左元素，也只临时保存了最左元素。
            // 如果从左开始，左右第一次互换的时候，会丢掉最右侧的值，结果就会产生偏差

            //此处是 arr[right] >= temp 而不是 arr[right] > temp？
            // 因为如果基准值和当前值相等也需要转移的话，就会出现arr[left] 和 arr[right] 一直相互转换
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
        // 在挖坑填数过程中，pivot的值会临时丢弃，直到low == high,而且此时low和high是最后一次调换的重复的数，此位置正确的值应该是tmp
        arr[low] = tmp;
        // 返回tmp的正确位置
        return low;


    }


    public static void main(String[] args) {
        int[] arrays = {9,34,56,22,8,1,46,99};
        int[] result = sort(arrays);
        Arrays.stream(result).forEach(System.out::println);
    }
}
