package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description 插入排序示例
 * 思路：从第二个元素开始(默认第一个最小)，依次和前面元素进行比较，如果比前面元素小，偏移一位继续与前面元素比较，直到匹配到正确位置。
 * @Author liuye
 * @Date 2020/9/26 12:16
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] arrays = {1, 34, 56, 22, 8, 1, 46, 99};
        int[] result = insertSort2(arrays);
        Arrays.stream(result).forEach(System.out::println);
    }


    /**
     * 插入排序方式
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            //临时保存当前待排序节点值
            int tmp = arr[i];

            //从未排序节点开始排序
            int j = i;

            //当前待排序节点小于排序节点最尾值,此时当前节点应该向前移动
            // j>0 判断要放前面，不然j=0时 arr[j-1] 就下标索引越界了
            while(j > 0 && tmp < arr[j - 1]){
                //当前比较的排序节点 向后移动一位
                arr[j] = arr[j-1];
                j--;
            }

            if (i != j){
                //节点插入到正确位置
                arr[j] = tmp;
            }
        }
        return arr;
    }


    /**
     * 插入排序方式
     *
     * @param arr
     * @return
     */
    public static int[] insertSort2(int[] arr) {
        // 插入排序
        for (int i = 1; i < arr.length; i++) {
            // 保存当前待排序节点值
            int tmp = arr[i];
            // 从未排序节点开始排序
            int j = i;
            // 当前待排序节点小于排序节点最尾值,此时当前节点应该向前移动
            while (j > 0 && tmp < arr[j - 1]) {
                // 当前比较的排序节点 向后移动一位
                arr[j] = arr[j - 1];
                j--;
            }
            // 节点插入到正确位置
            arr[j] = tmp;
        }
        return arr;
    }
}
