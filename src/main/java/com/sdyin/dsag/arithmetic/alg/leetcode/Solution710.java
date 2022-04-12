package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: 710. 黑名单中的随机数
 * 给定一个整数 n 和一个 无重复 黑名单整数数组blacklist。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个未加入黑名单blacklist的整数。
 * 任何在上述范围内且不在黑名单blacklist中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现Solution类:
 * <p>
 * Solution(int n, int[] blacklist)初始化整数 n 和被加入黑名单blacklist的整数
 * int pick()返回一个范围为 [0, n - 1] 且不在黑名单blacklist 中的随机整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/12$ 8:06 下午$
 */
public class Solution710 {

    //黑名单边界索引
    int boundary;
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public Solution710(int n, int[] blacklist) {
        boundary = n - blacklist.length;
        for (int i = 0; i < blacklist.length; i++) {
            map.put(blacklist[i], 0);
        }

        int last = n - 1;
        //循环处理黑名单元素
        for (int b : blacklist) {
            //如果b已经在区间[boundary, n),不用处理，已经在黑名单区
            if (b >= boundary) {
                continue;
            }
            //以下出现元素肯定全部在边界左边,需要处理。替换到黑名单区

            //黑名单区已有，则忽略，找到下一个可替换的索引
            while (map.containsKey(last)){
                last--;
            }
            //原本边界区左边的黑名单元素put非黑名单的值(方便pick函数取值)
            map.put(b, last);
            last--;
        }

    }

    public int pick() {
        final int i = random.nextInt(boundary);
        if(map.containsKey(i)) {
            return map.get(i);
        }
        return i;
    }
}
