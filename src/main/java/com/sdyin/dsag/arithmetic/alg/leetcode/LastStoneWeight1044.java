package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Description: 1044 最后一块石头的重量
 * //有一堆石头，每块石头的重量都是正整数。
 * //
 * // 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * //
 * //
 * // 如果 x == y，那么两块石头都会被完全粉碎；
 * // 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * //
 * //
 * // 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：[2,7,4,1,8,1]
 * //输出：1
 * //解释：
 * //先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * //再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * //接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * //最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= stones.length <= 30
 * // 1 <= stones[i] <= 1000
 * //
 * // Related Topics 堆 贪心算法
 * // 👍 121 👎 0
 * @Author: liuye
 * @time: 2020/12/30$ 下午1:53$
 */
public class LastStoneWeight1044 {

    /**
     * 暴力解法
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones).boxed().sorted().collect(Collectors.toList());
        while (list.size() > 1) {
            Integer i = list.get(list.size() - 1);
            Integer j = list.get(list.size() - 2);
            //移除倒数第一位
            list.remove(list.size() - 1);
            //移除倒数第二位，因为上面已经移除了最后一位，所以此时仍然是 list.size() - 1
            list.remove(list.size() - 1);
            if (!i.equals(j)) {
                list.add(i - j);
            }
            list.sort(Comparator.comparingInt(a -> a));
        }
        if (list.size() == 0) {
            return 0;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        final int result = lastStoneWeight(arr);
        System.out.println(result);
    }

    /**
     * 最大堆实现: 每次取出的第一个元素就是最大的元素
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight2(int[] stones) {
        //定义优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        //存入优先队列
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while (pq.size() > 1){
            final Integer a = pq.poll();
            final Integer b = pq.poll();
            if(!a.equals(b)){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
