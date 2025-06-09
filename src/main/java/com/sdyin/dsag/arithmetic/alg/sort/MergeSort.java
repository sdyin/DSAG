package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * 归并排序: 时间复杂度 n(logn),稳定排序
 * 分治: 先递归拆分 再比较合并
 * @Description
 * @Author liuye
 * @Date 2019/8/22 11:29
 */
public class MergeSort {

    public static void main(String[] args) throws Exception {
        int[] arrays = {18,3,14,9,55,24,3,58,99};
        int[] result = sort(arrays);
        Arrays.stream(result).forEach(System.out::println);
    }

    /**
     * 递归拆分,直至大小数量小于二
     * @param sourceArray
     * @return
     * @throws Exception
     */
    public static int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    /**
     * 合并排序
     * @param left
     * @param right
     * @return
     */
    protected  static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        // 左右子节点均有元素
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        //只有左节点有元素，直接添加左节点元素
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        //只有右节点有元素，直接添加右节点元素
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }


    /**
     * 归并排序- 解法二
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // 递归排序左半部分
            // 注意这里是mid, 为什么不是mid-1 ？
            // 归并排序将 mid 明确划归左半部分，这样分区是 [left, mid] 和 [mid+1, right]，确保每个元素都被处理且不重复
            mergeSort(arr, left, mid, temp);
            // 递归排序右半部分
            mergeSort(arr, mid + 1, right, temp);

            // 合并两个有序子数组
            merge(arr, left, mid, right, temp);
        }
    }


    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;     // 左子数组起始索引
        int j = mid + 1;  // 右子数组起始索引
        int k = 0;        // 临时数组索引

        // 合并两个有序子数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }


        // 将剩余元素拷贝到临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组中的元素拷贝回原数组
        System.arraycopy(temp, 0, arr, left, right - left + 1);
    }
}
