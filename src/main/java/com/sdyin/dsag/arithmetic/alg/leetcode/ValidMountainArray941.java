package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 941. 有效的山脉数组
 * 给定一个整数数组A，如果它是有效的山脉数组就返回true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在0 < i< A.length - 1条件下，存在i使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * @Author liuye
 * @Date 2020/11/3 15:32
 **/
public class ValidMountainArray941 {

    public boolean validMountainArray(int[] A) {

        int a = 0;
        int index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (i == 0) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            } else {
                if(A[i] > A[i + 1]){
                    //记录第一次index值
                    if(index == 0){
                        index = i;
                    }
                    a++;
                }
            }
        }

        if (index == 0 || a == 0) {
            return false;
        }
        if(index + a == A.length - 1){
            return true;
        }else{
            return false;
        }
    }
}
