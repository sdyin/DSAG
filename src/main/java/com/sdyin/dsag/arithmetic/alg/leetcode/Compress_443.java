package com.sdyin.dsag.arithmetic.alg.leetcode;

import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;

/**
 * @Description: 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * @Author: liuye
 * @time: 2023/8/31$ 11:29 上午$
 */
public class Compress_443 {

    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int count = 1;
            char c = chars[i];
            while (i + 1 < length && chars[i + 1] == c) {
                count++;
                i++;
            }
            sb.append(c);
            // 字符连续大于1时，才需要拼接数字
            if (count > 1) {
                sb.append(count);
            }
        }
        chars = sb.toString().toCharArray();
        return chars.length;
    }

    /**
     * 双指针解法
     * @param chars
     * @return
     */
    public static int compress2(char[] chars) {
        int n = chars.length;
        // 写指针,重新写入的位置
        int write = 0;
        int left = 0;
        for (int read = 0; read < n; read++) {
            // 当读指针到达最后一个元素 或者 当前元素与下一个元素不相等时
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                // 当前元素写入
                chars[write++] = chars[read];
                // 当前元素与下一个元素不相等时，需要写入当前元素的个数
                if (read > left) {
                    // 将数字转换为字符数组
                    char[] num = String.valueOf(read - left + 1).toCharArray();
                    // 将数字写入
                    for (char c : num) {
                        chars[write++] = c;
                    }
                }
                // 更新左指针
                left = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int length = compress2(chars);
        System.out.println(length);
    }
}
