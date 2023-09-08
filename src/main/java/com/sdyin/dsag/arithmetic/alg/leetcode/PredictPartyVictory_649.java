package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 649. Dota2 参议院
 * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
 *
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
 *
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
 * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
 * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 *
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 *
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 或 "Dire" 。
 * @Author: liuye
 * @time: 2023/9/8$ 6:12 下午$
 */
public class PredictPartyVictory_649 {

    /**
     * 使用了两个队列radiant和dire来分别存储Radiant和Dire阵营的索引。
     * 然后，通过循环遍历senate字符串，将每个议员的索引根据所属阵营放入对应的队列中。
     * 接下来，使用一个循环来模拟投票的过程，每次从radiant和dire队列中分别取出一个议员的索引。
     * 如果Radiant阵营的议员索引小于Dire阵营的议员索引，则将Radiant议员的索引加上n后重新放入radiant队列中；否则，将Dire议员的索引加上n后重新放入dire队列中。这样，每次投票都会淘汰索引较小的议员。
     * 最后，判断哪个队列为空，如果radiant队列为空，则Dire阵营获胜；如果dire队列为空，则Radiant阵营获胜。
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        //初始化队列
        Deque<Integer> radiant = new ArrayDeque<Integer>();
        Deque<Integer> dire = new ArrayDeque<Integer>();

        // 循环存储对应议员队列的下标索引
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') {
                radiant.offerFirst(i);
            } else {
                dire.offerFirst(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            Integer radiantValue = radiant.pollLast();
            Integer direValue = dire.pollLast();
            // 值小的可以参加下一轮
            if (radiantValue < direValue) {
                radiant.offerFirst(radiantValue + n);
            } else {
                dire.offerFirst(direValue + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
