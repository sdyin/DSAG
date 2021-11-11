package com.sdyin.dsag.arithmetic.alg.sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/11$ 2:40 下午$
 */
public class InsertSort2 {

    public static void main(String[] args) {
        int[] arr = {14,23,5,3,77,23};
        
        for (int i = 1; i < arr.length; i++) {
            int tmp =  arr[i];
            int j = i;
            //元素后移,先判断j>0，防止arr[j - 1] 角标越界
            while(j > 0 &&  tmp < arr[j - 1]){
                arr[j] = arr[j -1];
                --j;
            }
            //元素调整到正确索引处
            if(i != j){
                arr[j] = tmp;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);

    }
}
