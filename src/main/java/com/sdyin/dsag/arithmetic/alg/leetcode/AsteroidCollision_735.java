package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * @Author: liuye
 * @time: 2023/9/6$ 11:02 上午$
 */
public class AsteroidCollision_735 {

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> deque = new LinkedList<>();
        int length = asteroids.length;
        for (int i = 0; i < length; i++) {
            deque.addLast(asteroids[i]);
            while (deque.size() > 1) {
                // 移除当前节点(尾结点)
                Integer curValue = deque.removeLast();
                // 获取前一节点
                Integer preValue = deque.getLast();
                // 两行星相撞场景
                if (preValue > 0 && curValue < 0) {
                    // 两行星大小相同，移除前一个节点
                    if (Math.abs(preValue) == Math.abs(curValue)) {
                        deque.removeLast();
                    } else if (Math.abs(preValue) < Math.abs(curValue)) {
                        // 前一节点小于 当前节点,移除前一节点,添加当前节点
                        deque.removeLast();
                        deque.addLast(curValue);
                    } else {
                        // 前一节点大于 当前节点,已移除当前节点, 无需处理
                    }
                }
                // 不相撞, 重新添加当前节点
                else {
                    deque.addLast(curValue);
                    // 跳出当前while 循环
                    break;
                }
            }
        }
        int[] result = deque.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,2};
        int[] result = asteroidCollision(asteroids);
        Arrays.stream(result).forEach(System.out::println);
    }
}
