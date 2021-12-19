package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2021/1/1$ 下午6:05$
 */
public class CanPlaceFlowers605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return false;
        }

        int count = 0;
        int sum = 0;
        /**
         * 只有一个元素，且值为0的时候
         */
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return n <= 1;
        }
        /**
         * 其他场景
         */
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && i == 0) {
                sum += 2;
            } else if (flowerbed[i] == 0 && i != flowerbed.length - 1) {
                sum += 1;
            } else if (flowerbed[i] == 1) {
                int result1 = sum / 2;
                int result2 = sum % 2;
                count += (result2 > 0 ? result1 : result1 - 1);
                count = count < 0 ? 0 : count;
                sum = 0;
            } else if (flowerbed[i] == 0 && i == flowerbed.length - 1) {
                sum += 2;
                int result1 = sum / 2;
                int result2 = sum % 2;
                count += (result2 > 0 ? result1 : result1 - 1);
                count = count < 0 ? 0 : count;
                sum = 0;
            } else {

            }
        }
        return count >= n;
    }

    /**
     * 【1】当遍历到index遇到1时，说明这个位置有花，那必然从index+2的位置才有可能种花，因此当碰到1时直接跳过下一格。
     * 【2】当遍历到index遇到0时，由于每次碰到1都是跳两格，因此前一格必定是0，此时只需要判断下一格是不是1即可得出index这一格能不能种花，如果能种则令n减一，然后这个位置就按照遇到1时处理，即跳两格；如果index的后一格是1，说明这个位置不能种花且之后两格也不可能种花（参照【1】），直接跳过3格。
     *
     * 当n减为0时，说明可以种入n朵花，则可以直接退出遍历返回true；如果遍历结束n没有减到0，说明最多种入的花的数量小于n，则返回false。
     *
     * 作者：hatsune-miku-k
     * 链接：https://leetcode-cn.com/problems/can-place-flowers/solution/fei-chang-jian-dan-de-tiao-ge-zi-jie-fa-nhzwc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; ) {
            int value = flowerbed[i];
            int next = flowerbed[i + 1];
            if (value == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || next == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n < 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1, 0, 0};
        int n = 2;
        final boolean b = canPlaceFlowers(arr, n);
        System.out.println(b);
    }
}
