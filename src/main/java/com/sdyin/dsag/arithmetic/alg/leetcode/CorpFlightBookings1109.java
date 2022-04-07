package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1109. 航班预订统计
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表bookings ，
 * 表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 * <p>
 * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
 * @Author: liuye
 * @time: 2022/4/7$ 8:14 下午$
 */
public class CorpFlightBookings1109 {


    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (n <= 0) {
            return new int[]{0};
        }
        //差分数组初始化
        diff = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            //left，right 是下标索引,从0开始，所以减一
            int left = booking[0] - 1;
            int right = booking[1] -1;
            int value = booking[2];
            incr(left, right, value);
        }
        return result();
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
