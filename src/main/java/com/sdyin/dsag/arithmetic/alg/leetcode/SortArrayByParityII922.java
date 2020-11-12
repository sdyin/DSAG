package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 922. 按奇偶排序数组 II
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2020/11/12$ 下午8:02$
 */
public class SortArrayByParityII922 {

    public int[] sortArrayByParityII(int[] A) {
        Integer oddNum = 1;
        Integer evenNum = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0){
                map.put(oddNum, A[i]);
                oddNum+=2;
            }else{
                map.put(evenNum, A[i]);
                evenNum+=2;
            }
        }
        List<Integer> list = new ArrayList<>();
        map.keySet().stream().sorted().forEach(key -> {
            list.add(map.get(key));
        });
        int[] a = list.stream().mapToInt(Integer::intValue).toArray();
        return a;
    }

    public int[] sortArrayByParityII2(int[] A) {

        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i+=2) {
            //i为偶数，A[i] 要为偶数，为奇数情况需要调整
            if(A[i] % 2 == 1){
                while(A[j] % 2 == 1){
                    j = j + 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
