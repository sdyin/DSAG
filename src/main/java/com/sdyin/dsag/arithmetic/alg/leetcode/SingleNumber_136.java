package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 136. 只出现一次的数字
 *  给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @Author: liuye
 * @time: 2023/10/10$ 1:46 下午$
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            // 异或运算：相同为假(0)，不同为真(1)
            // 所以相同数字异或结果为0， 任何数字与0异或结果为其本身
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 12;
        int j = 12;
        int result = i ^ j;
        System.out.println(result);
    }
}
