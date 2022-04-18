package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Description: 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/18$ 11:06 下午$
 */
public class OpenLock752 {

    public int openLock(String[] deadends, String target) {
        //存放死亡数字集合
        Set<String> deadSet = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadSet.add(deadends[i]);
        }
        //记录走过的节点，防止重复循环
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Deque<String> q = new LinkedList<>();
        q.offer("0000");
        //解锁最小旋转次数
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            //扩散,非传统的一层，而是可以转换的一层
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (cur.equals(target)){
                    return step;
                }
                if (deadSet.contains(cur)) {
                    continue;
                }

                //每个索引位置的节点都可能旋转
                for (int j = 0; j < 4; j++) {
                    //先假设向上
                    String up = plusOne(cur, j);
                    //未访问过当前节点
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }

                    //也可能向下
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }

            //旋转次数自增
            step++;
        }
        //无匹配
        return -1;
    }

    // 将 s[j] 向上拨动一次
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9'){
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
