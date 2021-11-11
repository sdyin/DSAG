package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description 插入排序示例
 * @Author liuye
 * @Date 2020/9/26 12:16
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] arrays = {1, 34, 56, 22, 8, 1, 46, 99};
        int[] result = insertSort(arrays);
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
}
