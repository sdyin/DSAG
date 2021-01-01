package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2021/1/1$ 下午6:05$
 */
public class CanPlaceFlowers605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 0){
            return false;
        }

        int count = 0;
        int sum = 0;
        /**
         * 只有一个元素，且值为0的时候
         */
        if(flowerbed.length == 1 && flowerbed[0] == 0){
            return n <= 1;
        }
        /**
         * 其他场景
         */
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0 && i == 0){
                sum+=2;
            }else if(flowerbed[i] == 0 && i != flowerbed.length - 1){
                sum+=1;
            }else if(flowerbed[i] == 1){
                int result1 = sum / 2;
                int result2 = sum % 2;
                count+=(result2 > 0 ? result1 : result1 - 1);
                count = count < 0 ? 0 : count;
                sum = 0;
            }else if(flowerbed[i] == 0 && i == flowerbed.length - 1){
                sum+=2;
                int result1 = sum / 2;
                int result2 = sum % 2;
                count+=(result2 > 0 ? result1 : result1 - 1);
                count = count < 0 ? 0 : count;
                sum = 0;
            } else {

            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,0,0};
        int n = 2;
        final boolean b = canPlaceFlowers(arr, n);
        System.out.println(b);
    }
}
