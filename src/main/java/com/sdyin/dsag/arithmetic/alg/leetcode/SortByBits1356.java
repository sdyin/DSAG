package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.google.common.collect.Lists;
import sun.security.krb5.internal.crypto.Aes128CtsHmacSha1EType;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * @Author liuye
 * @Date 2020/11/6 10:55
 **/
public class SortByBits1356 {


    public static void main(String[] args) {
        //int[] arr = { 1024,512,256,128,64,32,16,8,4,2,1};
        int[] arr = { 1,2,3,4,5,6,7,8,9};
        sortByBits(arr);
    }

    public static int[] sortByBits(int[] arr) {
       int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //Integer.bitCount 返回转换二进制后 1的个数
            res[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        //数组大小排序
        Arrays.sort(res);

        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] % 1000000;
        }
        return res;
    }
}
