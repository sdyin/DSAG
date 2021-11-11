package com.sdyin.dsag.arithmetic.alg.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/9/18$ 5:40 下午$
 */
public class DpTest {

    public static void main(String[] args) {
        int n = 50;
        final long start = System.currentTimeMillis();
        int total = addAll(n);
        final long end = System.currentTimeMillis();
        final long start2 = System.currentTimeMillis();
        int total2 = addAllMemo(n);
        final long end2 = System.currentTimeMillis();
        System.out.println("递归方式: 值 ->" + total + " 耗时-> " + (end - start));
        System.out.println("递归备忘录方式: 值 ->" + total2 + " 耗时-> " + (end2 - start2));
    }

    /**
     * 最普通方式，依次累加
     *
     * @param n
     * @return
     */
    private static int addAll(int n) {
        if (n <= 1) {
            if (n == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return addAll(n - 1) + addAll(n - 2);
        }
    }

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * 备忘录方式
     *
     * @param n
     * @return
     */
    private static int addAllMemo(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if (n <= 1) {
            if (n == 1) {
                map.put(1,1);
                return 1;
            } else {
                return 0;
            }
        } else {
            int result =  addAll(n - 1) + addAll(n - 2);
            map.put(n, result);
            return result;
        }
    }


}
