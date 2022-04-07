package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 1094. 拼车
 * 车上最初有capacity个空座位。车只能向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数capacity和一个数组 trips , trip[i] = [numPassengersi, fromi, toi]表示第 i 次旅行有numPassengersi乘客，
 * 接他们和放他们的位置分别是fromi和toi。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false。
 *
 * 示例一：
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 *
 * 示例二：
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 *
 * 提示：
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi<= 100
 * 0 <= fromi< toi<= 1000
 * 1 <= capacity <= 105
 *
 *
 * @Author: liuye
 * @time: 2022/4/7$ 9:23 下午$
 */
public class CarPooling1094 {

    public boolean carPooling(int[][] trips, int capacity) {

        diff = new int[capacity];

        for (int i = 0; i < trips.length; i++) {
            int[] trip =  trips[i];
            int value = trip[0];
            int left = trip[1];
            //终点时已经下车,可以再上一人,即right 需要减1
            int right = trip[2] - 1;
            incr(left, right, value);
        }
        final int[] result = result();
        final boolean b = Arrays.stream(result).allMatch(i -> i <= capacity);
        return b;
    }

    // 差分数组
    private int[] diff;

    /**
     * 区间 [left, right] 均加上value，区间下标从0开始
     *
     * @param left
     * @param right
     * @param value
     * @return
     */
    public void incr(int left, int right, int value) {
        diff[left] += value;
        //如果right 等于差分数组长度，那么代表的是右边数据全部要相加
        //因为right是下标索引,所以加1
        if (right + 1 < diff.length) {
            diff[right+1] -= value;
        }
    }

    /**
     * 根据差分数组递推返回结果数组
     *
     * @return
     */
    public int[] result(){
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i-1] + diff[i];
        }
        return result;
    }
}
