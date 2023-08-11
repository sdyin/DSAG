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
 * @Author: liuye
 * @time: 2023/8/11$ 10:50 上午$
 */
public class Solution710_2 {

    //随机数取值范围大小
    int target_size;

    //map存储黑名单值，key为元素，value为替换的值(黑名单值需要替换为非黑名单值)
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Random random = new Random();

    //思路:
    // 1.首先随机数取值范围长度大小为 n - blacklist.size()，假设这个长度值为target_size,最终我们就要在target_size范围内随机取值
    // 2.那么我们要保证前target_size个元素都不存储黑名单元素值，所以如果前target_size个元素中存在黑名单元素，我们就要把黑名单元素替换为target_size以外，N以内的非黑名单元素
    // 3.最后在target_size范围内取值，先判断目标索引是否在黑名单内，在的话，从map中取出正确元素，不在则直接返回该索引值
    public Solution710_2(int n, int[] blacklist) {
        for (int b : blacklist) {
            // 先存储黑名单元素
            map.put(b, 0);
        }

        //范围内元素个数
        target_size = n - blacklist.length;
        int valid_index = target_size;

        for (int b : blacklist) {
            // 如果元素值本身就大于target_size，本身就在黑名单，无需处理
            if (b >= target_size) {
                continue;
            }
            // 从前向后，找不存在
            while (map.containsKey(valid_index)) {
                valid_index++;
            }
            // 把该黑名单索引位置的值替换为非黑名单元素的last
            map.put(b, valid_index);
            // 自增
            valid_index++;
        }
    }

    public int pick() {
        int index = random.nextInt(target_size);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(5);
            System.out.println(index);
        }
    }
}
