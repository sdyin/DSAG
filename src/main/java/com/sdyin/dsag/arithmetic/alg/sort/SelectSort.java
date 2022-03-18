package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序：先把第一位依次与后面位数比较，再依次从第二位开始与后面比较，依次循环
 * 时间复杂度 O(n 的平方)
 * @Author: liuye
 * @time: 2022/3/18$ 7:38 上午$
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {33,22,8,99,45,77};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        Arrays.stream(a).forEach(item -> System.out.println(item));
    }
}
